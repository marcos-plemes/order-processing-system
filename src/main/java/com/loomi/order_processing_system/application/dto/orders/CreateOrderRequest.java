package com.loomi.order_processing_system.application.dto.orders;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateOrderRequest(
        
        @NotNull(message = "customerId is required")
        Integer customerId,
        
        @NotEmpty(message = "items cannot be empty")
        List<@Valid CreateOrderItemRequest> items
) {
}
