package com.loomi.order_processing_system.application.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.loomi.order_processing_system.application.usecases.ProductsUseCases;
import com.loomi.order_processing_system.domain.products.Products;
import com.loomi.order_processing_system.domain.products.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsUseCases {
    
    private final ProductsRepository productsRepository;
    
    public ProductsServiceImpl(final ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    
    @Override
    public Page<Products> list(final Integer page, final Integer size) {
        return this.productsRepository.findAll(page, size);
    }
    
}
