package com.loomi.order_processing_system.adapters.out.entities;

import java.math.BigDecimal;

import com.loomi.order_processing_system.domain.products.Products;
import com.loomi.order_processing_system.domain.products.ProductsTypeEnum;
import com.loomi.order_processing_system.domain.products.ProductsTypeEnumConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class JpaProductsEntity {
    
    @Id
    @SequenceGenerator(name = "seq_products", sequenceName = "products_pro_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_products")
    @Column(name = "pro_id", nullable = false)
    private Integer id;
    
    @Column(name = "pro_name", nullable = false)
    private String name;
    
    @Column(name = "pro_type", nullable = false)
    @Convert(converter = ProductsTypeEnumConverter.class)
    private ProductsTypeEnum type;
    
    @Column(name = "pro_price", nullable = false)
    private BigDecimal price;
    
    @Column(name = "pro_stock_quantity", nullable = true)
    private Integer stockQuantity;
    
    @Column(name = "pro_active", nullable = false)
    private Boolean active;
    
    @Column(name = "pro_metadata", nullable = true)
    private String metadata;
    
    public JpaProductsEntity() {
    }
    
    public JpaProductsEntity(final Products products) {
        this.id = products.getId();
        this.name = products.getName();
        this.type = products.getType();
        this.price = products.getPrice();
        this.stockQuantity = products.getStockQuantity();
        this.active = products.getActive();
        this.metadata = products.getMetadata();
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
    
    public Integer getStockQuantity() {
        return this.stockQuantity;
    }
    
    public void setStockQuantity(final Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
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
