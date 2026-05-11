package com.loomi.order_processing_system.adapters.out.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.loomi.order_processing_system.domain.order_item.OrderItemRepository;
import com.loomi.order_processing_system.domain.orders.OrderItems;
import com.loomi.order_processing_system.domain.orders.Orders;
import com.loomi.order_processing_system.domain.products.Products;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {
    
    private final JpaOrderItemRepository jpaOrderItemRepository;
    
    public OrderItemRepositoryImpl(final JpaOrderItemRepository jpaOrderItemRepository) {
        this.jpaOrderItemRepository = jpaOrderItemRepository;
    }
    
    @Override
    public List<OrderItems> findAllByOrderId(final int orderId) {
        return this.jpaOrderItemRepository.findAllByOrderId(orderId)
                                          .stream()
                                          .map(entity -> new OrderItems(
                                                  entity.getId(),
                                                  new Orders(
                                                          entity.getOrder().getId(),
                                                          entity.getOrder().getCustomer(),
                                                          entity.getOrder().getStatus(),
                                                          entity.getOrder().getTotalAmount(),
                                                          entity.getOrder().getFailureReason(),
                                                          entity.getOrder().getCreatedAt(),
                                                          entity.getOrder().getUpdatedAt()
                                                  ),
                                                  new Products(
                                                          entity.getProduct().getId(),
                                                          entity.getProduct().getName(),
                                                          entity.getProduct().getType(),
                                                          entity.getProduct().getPrice(),
                                                          entity.getProduct().getStockQuantity(),
                                                          entity.getProduct().getActive(),
                                                          entity.getProduct().getMetadata()
                                                  ),
                                                  entity.getQuantity(),
                                                  entity.getUnitPrice(),
                                                  entity.getMetadata()
                                          )).collect(Collectors.toList());
    }
    
}
