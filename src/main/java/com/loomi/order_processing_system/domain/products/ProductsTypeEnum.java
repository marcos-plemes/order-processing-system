package com.loomi.order_processing_system.domain.products;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loomi.order_processing_system.enums.EnumConverter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductsTypeEnum implements EnumConverter<Integer> {
    
    PHYSICAL(1, "Physical Products"),
    SUBSCRIPTION(2, "Subscription Products"),
    DIGITAL(3, "Digital Products"),
    PRE_ORDER(4, "Pre-Order Products"),
    CORPORATE(5, "Corporate Products");
    
    private final Integer id;
    
    private final String description;
    
    ProductsTypeEnum(final Integer id, final String description) {
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
