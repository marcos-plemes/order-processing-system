package com.loomi.order_processing_system.domain.orders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.loomi.order_processing_system.application.dto.orders.CreateOrderRequest;

public class Orders {
    
    private Integer id;
    
    private Integer customer;
    
    private OrdersStatusEnum status;
    
    private BigDecimal totalAmount;
    
    private String failureReason;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    private List<OrderItems> items;
    
    public Orders() {
    }
    
    public Orders(final CreateOrderRequest createOrderRequest) {
        this.customer = createOrderRequest.customerId();
        this.status = OrdersStatusEnum.PENDING;
        this.totalAmount = BigDecimal.ZERO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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
    
    public List<OrderItems> getItems() {
        return this.items;
    }
    
    public void setItems(final List<OrderItems> items) {
        this.items = items;
    }
    
    public void addItem(final OrderItems item) {
        if (Objects.isNull(this.items)) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        this.totalAmount = this.totalAmount.add(item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
    }
    
}
