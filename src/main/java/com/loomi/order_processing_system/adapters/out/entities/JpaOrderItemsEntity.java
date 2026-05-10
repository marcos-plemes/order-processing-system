package com.loomi.order_processing_system.adapters.out.entities;

import java.math.BigDecimal;

import com.loomi.order_processing_system.domain.orders.OrderItems;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class JpaOrderItemsEntity {
    
    @Id
    @SequenceGenerator(name = "seq_order_items", sequenceName = "order_items_oit_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order_items")
    @Column(name = "oit_id", nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oit_order_id", nullable = false)
    private JpaOrdersEntity order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oit_product_id", nullable = false)
    private JpaProductsEntity product;
    
    @Column(name = "oit_quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "oit_unit_price", nullable = false)
    private BigDecimal unitPrice;
    
    @Column(name = "oit_metadata")
    private String metadata;
    
    public JpaOrderItemsEntity() {
    }
    
    public JpaOrderItemsEntity(final OrderItems orderItems, final JpaOrdersEntity jpaOrdersEntity) {
        this.id = orderItems.getId();
        this.order = jpaOrdersEntity;
        this.product = new JpaProductsEntity(orderItems.getProduct());
        this.quantity = orderItems.getQuantity();
        this.unitPrice = orderItems.getUnitPrice();
        this.metadata = orderItems.getMetadata();
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public JpaOrdersEntity getOrder() {
        return this.order;
    }
    
    public void setOrder(final JpaOrdersEntity order) {
        this.order = order;
    }
    
    public JpaProductsEntity getProduct() {
        return this.product;
    }
    
    public void setProduct(final JpaProductsEntity product) {
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
