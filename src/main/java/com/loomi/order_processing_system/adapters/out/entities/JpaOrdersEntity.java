package com.loomi.order_processing_system.adapters.out.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.loomi.order_processing_system.domain.orders.Orders;
import com.loomi.order_processing_system.domain.orders.OrdersStatusEnum;
import com.loomi.order_processing_system.domain.orders.OrdersStatusEnumConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class JpaOrdersEntity {
    
    @Id
    @SequenceGenerator(name = "seq_orders", sequenceName = "orders_ord_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orders")
    @Column(name = "ord_id", nullable = false)
    private Integer id;
    
    @Column(name = "ord_customer_id", nullable = false)
    private Integer customer;
    
    @Column(name = "ord_status", nullable = false)
    @Convert(converter = OrdersStatusEnumConverter.class)
    private OrdersStatusEnum status;
    
    @Column(name = "ord_total_amount", nullable = false)
    private BigDecimal totalAmount;
    
    @Column(name = "ord_failure_reason")
    private String failureReason;
    
    @Column(name = "ord_created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "ord_updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<JpaOrderItemsEntity> items;
    
    public JpaOrdersEntity() {
    }
    
    public JpaOrdersEntity(final Orders order) {
        this.id = order.getId();
        this.customer = order.getCustomer();
        this.status = order.getStatus();
        this.totalAmount = order.getTotalAmount();
        this.failureReason = order.getFailureReason();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
        this.items = order.getItems()
                          .stream()
                          .map(item -> new JpaOrderItemsEntity(item, this))
                          .collect(Collectors.toList());
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Integer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(final Integer customer) {
        this.customer = customer;
    }
    
    public OrdersStatusEnum getStatus() {
        return this.status;
    }
    
    public void setStatus(final OrdersStatusEnum status) {
        this.status = status;
    }
    
    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }
    
    public void setTotalAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getFailureReason() {
        return this.failureReason;
    }
    
    public void setFailureReason(final String failureReason) {
        this.failureReason = failureReason;
    }
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public List<JpaOrderItemsEntity> getItems() {
        return this.items;
    }
    
    public void setItems(final List<JpaOrderItemsEntity> items) {
        this.items = items;
    }
    
}
