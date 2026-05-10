package com.loomi.order_processing_system.adapters.out.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.loomi.order_processing_system.domain.products.Products;
import com.loomi.order_processing_system.domain.products.ProductsRepository;

@Repository
public class ProductsRepositoryImpl implements ProductsRepository {
    
    private final JpaProductsRepository jpaProductsRepository;
    
    public ProductsRepositoryImpl(final JpaProductsRepository jpaProductsRepository) {
        this.jpaProductsRepository = jpaProductsRepository;
    }
    
    @Override
    public Page<Products> findAll(final Integer page, final Integer size) {
        return this.jpaProductsRepository
                .findAll(PageRequest.of(page, size, Sort.by("id").ascending()))
                .map(entity -> new Products(
                        entity.getId(),
                        entity.getName(),
                        entity.getType(),
                        entity.getPrice(),
                        entity.getStock_quantity(),
                        entity.getActive(),
                        entity.getMetadata()
                ));
    }
    
}
