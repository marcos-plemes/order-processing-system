package com.loomi.order_processing_system.application.usecases;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;

public interface ProcessOrderUseCase {
    
    void process(OrderCreatedEvent event);
    
}
