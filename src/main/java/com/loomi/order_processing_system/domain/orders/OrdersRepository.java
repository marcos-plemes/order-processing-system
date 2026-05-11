package com.loomi.order_processing_system.domain.orders;

import java.util.Optional;

public interface OrdersRepository {
    
    Orders save(Orders order);
    
    Optional<Orders> findById(Integer id);
    
    void update(Orders order);
    
}
