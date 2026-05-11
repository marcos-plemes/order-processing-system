package com.loomi.order_processing_system.adapters.out.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loomi.order_processing_system.adapters.out.entities.JpaOrderItemsEntity;

public interface JpaOrderItemRepository extends JpaRepository<JpaOrderItemsEntity, Integer> {
    
    @Query("""
               SELECT oi
               FROM JpaOrderItemsEntity oi
               WHERE oi.order.id = :orderId
           """)
    List<JpaOrderItemsEntity> findAllByOrderId(@Param("orderId") Integer orderId);
    
}
