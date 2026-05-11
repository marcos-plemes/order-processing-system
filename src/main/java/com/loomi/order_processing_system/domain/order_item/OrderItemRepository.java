package com.loomi.order_processing_system.domain.order_item;

import java.util.List;

import com.loomi.order_processing_system.domain.orders.OrderItems;

public interface OrderItemRepository {
    
    List<OrderItems> findAllByOrderId(int orderId);
    
}
