package com.loomi.order_processing_system.adapters.out.messaging.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;

@Component
public class OrderCreatedProducer {
    
    private final KafkaTemplate<String, Object> kafkaTemplate;
    
    public OrderCreatedProducer(final KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void publish(final OrderCreatedEvent event) {
        
        this.kafkaTemplate.send(
                "order-created",
                event.orderId().toString(),
                event
                               );
    }
    
}