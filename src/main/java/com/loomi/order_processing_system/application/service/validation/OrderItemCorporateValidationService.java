package com.loomi.order_processing_system.application.service.validation;

import org.springframework.stereotype.Service;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;
import com.loomi.order_processing_system.domain.orders.OrderItems;
import com.loomi.order_processing_system.domain.orders.Orders;

@Service
public class OrderItemCorporateValidationService extends OrderItemValidation {
    
    @Override
    public void validate(final Orders order, final OrderItems item, final OrderCreatedEvent event) {
    
    }
    
}
