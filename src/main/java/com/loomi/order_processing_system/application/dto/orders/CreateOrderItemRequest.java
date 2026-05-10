package com.loomi.order_processing_system.application.dto.orders;

import java.util.Map;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateOrderItemRequest(
        
        @NotNull(message = "productId is required")
        Integer productId,
        
        @Min(value = 1, message = "quantity must be greater than zero")
        @NotNull(message = "quantity is required")
        Integer quantity,
        
        Map<String, Object> metadata
) {
}
