package com.loomi.order_processing_system.application.usecases;

import com.loomi.order_processing_system.application.dto.orders.CreateOrderRequest;
import com.loomi.order_processing_system.application.dto.orders.CreateOrderResponse;

public interface CreateOrderUseCase {
    
    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
    
}
