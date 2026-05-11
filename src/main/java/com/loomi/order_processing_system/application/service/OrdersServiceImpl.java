package com.loomi.order_processing_system.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loomi.order_processing_system.application.usecases.OrderItemUseCase;
import com.loomi.order_processing_system.application.usecases.OrdersUseCase;
import com.loomi.order_processing_system.domain.orders.Orders;
import com.loomi.order_processing_system.domain.orders.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersUseCase {
    
    private final OrdersRepository ordersRepository;
    
    private final OrderItemUseCase orderItemUseCase;
    
    public OrdersServiceImpl(
            final OrdersRepository ordersRepository,
            final OrderItemUseCase orderItemUseCase) {
        this.ordersRepository = ordersRepository;
        this.orderItemUseCase = orderItemUseCase;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Orders> findById(final Integer id) {
        return this.ordersRepository.findById(id)
                                    .map(this::loadItems);
    }
    
    @Override
    public void updateOrders(final Orders orders) {
        this.ordersRepository.update(orders);
    }
    
    private Orders loadItems(final Orders order) {
        order.setItems(this.orderItemUseCase.findAllByOrderId(order.getId()));
        
        return order;
    }
    
}
