package com.loomi.order_processing_system.domain.products;

import java.util.Optional;

import org.springframework.data.domain.Page;

public interface ProductsRepository {
    
    Page<Products> findAll(Integer page, Integer size);
    
    Optional<Products> findById(Integer id);
    
}
