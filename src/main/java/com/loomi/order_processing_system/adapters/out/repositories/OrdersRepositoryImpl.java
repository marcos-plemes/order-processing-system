package com.loomi.order_processing_system.adapters.out.repositories;

import org.springframework.stereotype.Repository;

import com.loomi.order_processing_system.adapters.out.entities.JpaOrdersEntity;
import com.loomi.order_processing_system.domain.orders.Orders;
import com.loomi.order_processing_system.domain.orders.OrdersRepository;

@Repository
public class OrdersRepositoryImpl implements OrdersRepository {
    
    private final JpaOrdersRepository jpaOrdersRepository;
    
    public OrdersRepositoryImpl(final JpaOrdersRepository jpaOrdersRepository) {
        this.jpaOrdersRepository = jpaOrdersRepository;
    }
    
    @Override
    public Orders save(final Orders order) {
        JpaOrdersEntity entity = new JpaOrdersEntity(order);
        entity = this.jpaOrdersRepository.save(entity);
        order.setId(entity.getId());
        return order;
    }
    
}
