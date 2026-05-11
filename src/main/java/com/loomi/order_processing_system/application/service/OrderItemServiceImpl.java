package com.loomi.order_processing_system.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loomi.order_processing_system.application.usecases.OrderItemUseCase;
import com.loomi.order_processing_system.domain.order_item.OrderItemRepository;
import com.loomi.order_processing_system.domain.orders.OrderItems;

@Service
public class OrderItemServiceImpl implements OrderItemUseCase {
    
    private final OrderItemRepository orderItemRepository;
    
    public OrderItemServiceImpl(final OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<OrderItems> findAllByOrderId(final Integer orderId) {
        return this.orderItemRepository.findAllByOrderId(orderId);
    }
    
}
