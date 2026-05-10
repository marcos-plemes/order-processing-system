package com.loomi.order_processing_system.domain.products;

import java.math.BigDecimal;

public class Products {
    
    private Integer id;
    
    private String name;
    
    private ProductsTypeEnum type;
    
    private BigDecimal price;
    
    private Integer stock_quantity;
    
    private Boolean active;
    
    private String metadata;
    
    public Products() {
    }
    
    public Products(
            final Integer id,
            final String name,
            final ProductsTypeEnum type,
            final BigDecimal price,
            final Integer stock_quantity,
            final Boolean active,
            final String metadata) {
        
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.active = active;
        this.metadata = metadata;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public ProductsTypeEnum getType() {
        return this.type;
    }
    
    public void setType(final ProductsTypeEnum type) {
        this.type = type;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }
    
    public Integer getStock_quantity() {
        return this.stock_quantity;
    }
    
    public void setStock_quantity(final Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }
    
    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(final Boolean active) {
        this.active = active;
    }
    
    public String getMetadata() {
        return this.metadata;
    }
    
    public void setMetadata(final String metadata) {
        this.metadata = metadata;
    }
    
}
