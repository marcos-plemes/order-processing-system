package com.loomi.order_processing_system.application.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;
import com.loomi.order_processing_system.application.service.validation.OrderGlobalValidationService;
import com.loomi.order_processing_system.application.service.validation.OrderItemValidation;
import com.loomi.order_processing_system.application.usecases.OrdersUseCase;
import com.loomi.order_processing_system.application.usecases.ProcessOrderUseCase;
import com.loomi.order_processing_system.domain.orders.OrderItems;
import com.loomi.order_processing_system.domain.orders.Orders;
import com.loomi.order_processing_system.domain.orders.OrdersStatusEnum;
import com.loomi.order_processing_system.infrastructure.exceptions.NotFoundException;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderUseCase {
    
    private final OrdersUseCase ordersUseCase;
    
    private final OrderGlobalValidationService orderGlobalValidationService;
    
    private final ApplicationContext applicationContext;
    
    public ProcessOrderServiceImpl(
            final OrdersUseCase ordersUseCase,
            final OrderGlobalValidationService orderGlobalValidationService,
            final ApplicationContext applicationContext) {
        this.ordersUseCase = ordersUseCase;
        this.orderGlobalValidationService = orderGlobalValidationService;
        this.applicationContext = applicationContext;
    }
    
    @Override
    public void process(final OrderCreatedEvent event) {
        final Orders orders = this.ordersUseCase.findById(event.orderId()).orElseThrow(() -> new NotFoundException("Order not found with id: " + event.orderId()));
        
        if (!orders.getStatus().equals(OrdersStatusEnum.PENDING)) {
            return;
        }
        
        this.startProcessing(orders);
        this.orderGlobalValidationService.validate(orders, event);
        
        for (final OrderItems item : orders.getItems()) {
            final OrderItemValidation validation = this.applicationContext.getBean(item.getProduct().getType().getValidationService());
            validation.validate(orders, item, event);
        }
    }
    
    private void startProcessing(final Orders orders) {
        orders.setStatus(OrdersStatusEnum.PROCESSING);
        this.ordersUseCase.updateOrders(orders);
    }
    
}
