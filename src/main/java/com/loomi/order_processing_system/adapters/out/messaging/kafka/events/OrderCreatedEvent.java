package com.loomi.order_processing_system.adapters.out.messaging.kafka.events;

import java.math.BigDecimal;

public record OrderCreatedEvent(
        Integer orderId,
        Integer customerId,
        BigDecimal totalAmount,
        Integer idStatus
) {
}