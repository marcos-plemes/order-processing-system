package com.loomi.order_processing_system.application.service.validation;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;
import com.loomi.order_processing_system.adapters.out.messaging.kafka.producer.OrderProducer;
import com.loomi.order_processing_system.application.usecases.OrdersUseCase;
import com.loomi.order_processing_system.domain.orders.Orders;
import com.loomi.order_processing_system.domain.orders.OrdersStatusEnum;
import com.loomi.order_processing_system.enums.KafkaTopicEnum;

@Service
public class OrderGlobalValidationService {
    
    private final OrderProducer orderProducer;
    
    private final OrdersUseCase ordersUseCase;
    
    public OrderGlobalValidationService(final OrderProducer orderProducer, final OrdersUseCase ordersUseCase) {
        this.orderProducer = orderProducer;
        this.ordersUseCase = ordersUseCase;
    }
    
    private void validateHighValueOrder(final Orders order) {
        
        if (order.getTotalAmount().compareTo(new BigDecimal("10000")) > 0) {
            System.out.println("High value order detected");
        }
    }
    
    private void validateFraud(final Orders order, final OrderCreatedEvent event) {
        
        if (order.getTotalAmount().compareTo(new BigDecimal("20000")) > 0) {
            
            final boolean fraudDetected = Math.random() < 0.05;
            
            if (fraudDetected) {
                order.setStatus(OrdersStatusEnum.FAILED);
                order.setFailureReason("FRAUD_DETECTED");
                this.ordersUseCase.updateOrders(order);
                this.orderProducer.publish(KafkaTopicEnum.FRAUD_DETECTED, event);
                throw new RuntimeException("FRAUD_DETECTED");
            }
        }
    }
    
    public void validate(final Orders orders, final OrderCreatedEvent event) {
        this.validateHighValueOrder(orders);
        this.validateFraud(orders, event);
    }
    
}
