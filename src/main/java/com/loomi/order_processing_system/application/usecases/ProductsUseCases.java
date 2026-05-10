package com.loomi.order_processing_system.application.usecases;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.loomi.order_processing_system.domain.products.Products;

public interface ProductsUseCases {
    
    Page<Products> list(Integer page, Integer size);
    
    Optional<Products> findById(Integer id);
    
}
