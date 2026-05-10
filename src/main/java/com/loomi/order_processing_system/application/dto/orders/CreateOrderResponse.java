package com.loomi.order_processing_system.application.dto.orders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.loomi.order_processing_system.domain.orders.OrdersStatusEnum;

public record CreateOrderResponse(
        
        Integer orderId,
        
        OrdersStatusEnum status,
        
        BigDecimal totalAmount,
        
        LocalDateTime createdAt
) {
}
