package com.loomi.order_processing_system.domain.orders;

import com.loomi.order_processing_system.enums.EnumAttributeConverterAbstract;

import jakarta.persistence.Converter;

@Converter
public class OrdersStatusEnumConverter extends EnumAttributeConverterAbstract<OrdersStatusEnum, Integer> {
    
}
