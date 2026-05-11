package com.loomi.order_processing_system.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum KafkaTopicEnum implements EnumConverter<Integer> {
    ORDER_CREATED(1, "order-created"),
    FRAUD_DETECTED(2, "fraud-detected");
    
    private final Integer id;
    
    private final String description;
    
    KafkaTopicEnum(final Integer id, final String description) {
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
