package com.loomi.order_processing_system.application.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public Page<Products> list(final Integer page, final Integer size) {
        return this.productsRepository.findAll(page, size);
    }
    
    @Override
    public Optional<Products> findById(final Integer id) {
        return this.productsRepository.findById(id);
    }
    
}
