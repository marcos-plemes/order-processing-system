package com.loomi.order_processing_system.adapters.in.messaging.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;
import com.loomi.order_processing_system.application.usecases.ProcessOrderUseCase;

@Component
public class OrderCreatedConsumer {
    
    private final ProcessOrderUseCase processOrderUseCase;
    
    public OrderCreatedConsumer(final ProcessOrderUseCase processOrderUseCase) {
        this.processOrderUseCase = processOrderUseCase;
    }
    
    @KafkaListener(
            topics = "order-created",
            groupId = "order-group"
    )
    public void consume(final OrderCreatedEvent event) {
        this.processOrderUseCase.process(event);
    }
    
}