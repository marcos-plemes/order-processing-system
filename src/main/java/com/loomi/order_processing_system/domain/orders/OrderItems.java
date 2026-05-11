package com.loomi.order_processing_system.domain.orders;

import java.math.BigDecimal;

import com.loomi.order_processing_system.domain.products.Products;

public class OrderItems {
    
    private Integer id;
    
    private Orders order;
    
    private Products product;
    
    private Integer quantity;
    
    private BigDecimal unitPrice;
    
    private String metadata;
    
    public OrderItems() {
    }
    
    public OrderItems(
            final Orders order,
            final Products product,
            final Integer quantity,
            final BigDecimal unitPrice,
            final String metadata) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.metadata = metadata;
    }
    
    public OrderItems(
            final Integer id,
            final Orders order,
            final Products product,
            final Integer quantity,
            final BigDecimal unitPrice,
            final String metadata) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.metadata = metadata;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Orders getOrder() {
        return this.order;
    }
    
    public void setOrder(final Orders order) {
        this.order = order;
    }
    
    public Products getProduct() {
        return this.product;
    }
    
    public void setProduct(final Products product) {
        this.product = product;
    }
    
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
    
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(final BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public String getMetadata() {
        return this.metadata;
    }
    
    public void setMetadata(final String metadata) {
        this.metadata = metadata;
    }
    
}
