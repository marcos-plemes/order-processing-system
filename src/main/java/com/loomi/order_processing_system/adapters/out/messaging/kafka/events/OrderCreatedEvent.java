package com.loomi.order_processing_system.adapters.out.messaging.kafka.events;

import java.math.BigDecimal;

import com.loomi.order_processing_system.domain.orders.OrdersStatusEnum;

public record OrderCreatedEvent(
        Integer orderId,
        Integer customerId,
        BigDecimal totalAmount,
        OrdersStatusEnum status
) {
}