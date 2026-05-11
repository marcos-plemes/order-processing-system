package com.loomi.order_processing_system.application.usecases;

import java.util.List;

import com.loomi.order_processing_system.domain.orders.OrderItems;

public interface OrderItemUseCase {
    
    List<OrderItems> findAllByOrderId(Integer orderId);
    
}
