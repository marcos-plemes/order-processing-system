package com.loomi.order_processing_system.adapters.out.repositories;

import java.util.Optional;

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
    
    @Override
    public Optional<Orders> findById(final Integer id) {
        return this.jpaOrdersRepository.findById(id)
                                       .map(entity -> new Orders(
                                               entity.getId(),
                                               entity.getCustomer(),
                                               entity.getStatus(),
                                               entity.getTotalAmount(),
                                               entity.getFailureReason(),
                                               entity.getCreatedAt(),
                                               entity.getUpdatedAt()
                                       ));
    }
    
    @Override
    public void update(final Orders order) {
        this.jpaOrdersRepository.save(new JpaOrdersEntity(order));
    }
    
}
