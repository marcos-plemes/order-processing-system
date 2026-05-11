package com.loomi.order_processing_system.application.service.validation;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;
import com.loomi.order_processing_system.domain.orders.OrderItems;
import com.loomi.order_processing_system.domain.orders.Orders;

public abstract class OrderItemValidation {
    
    public abstract void validate(Orders order, OrderItems item, OrderCreatedEvent event);
    
}
