package com.loomi.order_processing_system.application.usecases;

import java.util.Optional;

import com.loomi.order_processing_system.domain.orders.Orders;

public interface OrdersUseCase {
    
    Optional<Orders> findById(final Integer id);
    
    void updateOrders(final Orders orders);
    
}
