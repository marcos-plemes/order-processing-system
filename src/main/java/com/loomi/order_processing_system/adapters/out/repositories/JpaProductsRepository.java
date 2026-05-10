package com.loomi.order_processing_system.adapters.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loomi.order_processing_system.adapters.out.entities.JpaProductsEntity;

public interface JpaProductsRepository extends JpaRepository<JpaProductsEntity, Integer> {
}
