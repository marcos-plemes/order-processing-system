package com.loomi.order_processing_system.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;
import com.loomi.order_processing_system.adapters.out.messaging.kafka.producer.OrderProducer;
import com.loomi.order_processing_system.application.dto.orders.CreateOrderItemRequest;
import com.loomi.order_processing_system.application.dto.orders.CreateOrderRequest;
import com.loomi.order_processing_system.application.dto.orders.CreateOrderResponse;
import com.loomi.order_processing_system.application.usecases.CreateOrderUseCase;
import com.loomi.order_processing_system.application.usecases.ProductsUseCases;
import com.loomi.order_processing_system.domain.orders.OrderItems;
import com.loomi.order_processing_system.domain.orders.Orders;
import com.loomi.order_processing_system.domain.orders.OrdersRepository;
import com.loomi.order_processing_system.domain.products.Products;
import com.loomi.order_processing_system.enums.KafkaTopicEnum;
import com.loomi.order_processing_system.infrastructure.exceptions.BusinessException;
import com.loomi.order_processing_system.infrastructure.exceptions.NotFoundException;
import com.loomi.order_processing_system.utils.JsonUtils;

@Service
public class CreateOrderServiceImpl implements CreateOrderUseCase {
    
    private final ProductsUseCases productsUseCases;
    
    private final OrdersRepository ordersRepository;
    
    private final OrderProducer orderProducer;
    
    public CreateOrderServiceImpl(
            final ProductsUseCases productsUseCases,
            final OrdersRepository ordersRepository,
            final OrderProducer orderProducer) {
        
        this.productsUseCases = productsUseCases;
        this.ordersRepository = ordersRepository;
        this.orderProducer = orderProducer;
    }
    
    @Override
    @Transactional(readOnly = false)
    public CreateOrderResponse createOrder(final CreateOrderRequest createOrderRequest) {
        Orders order = new Orders(createOrderRequest);
        
        for (final CreateOrderItemRequest itemRequest : createOrderRequest.items()) {
            final Products product = this.productsUseCases.findById(itemRequest.productId())
                                                          .orElseThrow(() -> new NotFoundException(String.format("Product with id %s not found", itemRequest.productId())));
            this.validateProductIsActive(itemRequest, product);
            
            order.addItem(new OrderItems(
                    order,
                    product,
                    itemRequest.quantity(),
                    product.getPrice(),
                    JsonUtils.toJson(itemRequest.metadata())
            ));
            
        }
        
        order = this.ordersRepository.save(order);
        
        this.orderProducer.publish(
                KafkaTopicEnum.ORDER_CREATED,
                new OrderCreatedEvent(
                        order.getId(),
                        order.getCustomer(),
                        order.getTotalAmount(),
                        order.getStatus().getId()));
        
        return new CreateOrderResponse(
                order.getId(),
                order.getStatus(),
                order.getTotalAmount(),
                order.getCreatedAt()
        );
    }
    
    private void validateProductIsActive(final CreateOrderItemRequest itemRequest, final Products product) {
        if (!product.getActive()) {
            throw new BusinessException(String.format("Product with id %s is not active", itemRequest.productId()));
        }
    }
    
}
