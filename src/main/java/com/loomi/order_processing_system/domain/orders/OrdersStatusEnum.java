package com.loomi.order_processing_system.domain.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loomi.order_processing_system.enums.EnumConverter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrdersStatusEnum implements EnumConverter<Integer> {
    
    PENDING(1, "PENDING"),
    PROCESSING(2, "PROCESSING"),
    PROCESSED(3, "PROCESSED"),
    FAILED(4, "FAILED"),
    PENDING_APROVAL(5, "PENDING APROVAL");
    
    private final Integer id;
    
    private final String description;
    
    OrdersStatusEnum(final Integer id, final String description) {
        this.id = id;
        this.description = description;
    }
    
    @Override
    public Integer getId() {
        return this.id;
    }
    
    public String getDescription() {
        return this.description;
    }
}
