package com.loomi.order_processing_system.adapters.in;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loomi.order_processing_system.application.usecases.ProductsUseCases;
import com.loomi.order_processing_system.domain.products.Products;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    private final ProductsUseCases productsUseCases;
    
    public ProductsController(final ProductsUseCases productsUseCases) {
        this.productsUseCases = productsUseCases;
    }
    
    @GetMapping
    public Page<Products> list(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size) {
        
        return this.productsUseCases.list(page, size);
    }
    
}
