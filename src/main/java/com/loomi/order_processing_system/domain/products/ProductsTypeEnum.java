package com.loomi.order_processing_system.domain.products;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loomi.order_processing_system.application.service.validation.OrderItemCorporateValidationService;
import com.loomi.order_processing_system.application.service.validation.OrderItemDigitalValidationService;
import com.loomi.order_processing_system.application.service.validation.OrderItemPhysicalValidationService;
import com.loomi.order_processing_system.application.service.validation.OrderItemPreOrderValidationService;
import com.loomi.order_processing_system.application.service.validation.OrderItemSubscriptionValidationService;
import com.loomi.order_processing_system.application.service.validation.OrderItemValidation;
import com.loomi.order_processing_system.enums.EnumConverter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductsTypeEnum implements EnumConverter<Integer> {
    
    PHYSICAL(1, "Physical Products", OrderItemPhysicalValidationService.class),
    SUBSCRIPTION(2, "Subscription Products", OrderItemSubscriptionValidationService.class),
    DIGITAL(3, "Digital Products", OrderItemDigitalValidationService.class),
    PRE_ORDER(4, "Pre-Order Products", OrderItemPreOrderValidationService.class),
    CORPORATE(5, "Corporate Products", OrderItemCorporateValidationService.class);
    
    private final Integer id;
    
    private final String description;
    
    private final Class<? extends OrderItemValidation> validationService;
    
    ProductsTypeEnum(
            final Integer id,
            final String description,
            final Class<? extends OrderItemValidation> validationService) {
        this.id = id;
        this.description = description;
        this.validationService = validationService;
    }
    
    @Override
    public Integer getId() {
        return this.id;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public Class<? extends OrderItemValidation> getValidationService() {
        return this.validationService;
    }
}
