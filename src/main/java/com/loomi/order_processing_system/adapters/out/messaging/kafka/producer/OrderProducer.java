package com.loomi.order_processing_system.adapters.out.messaging.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.loomi.order_processing_system.adapters.out.messaging.kafka.events.OrderCreatedEvent;
import com.loomi.order_processing_system.enums.KafkaTopicEnum;

@Component
public class OrderProducer {
    
    private final KafkaTemplate<String, Object> kafkaTemplate;
    
    public OrderProducer(final KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void publish(final KafkaTopicEnum topic, final OrderCreatedEvent event) {
        
        this.kafkaTemplate.send(
                topic.getDescription(),
                event.orderId().toString(),
                event
                               );
    }
    
}