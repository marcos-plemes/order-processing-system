package com.loomi.order_processing_system.domain.products;

import com.loomi.order_processing_system.enums.EnumAttributeConverterAbstract;

import jakarta.persistence.Converter;

@Converter
public class ProductsTypeEnumConverter extends EnumAttributeConverterAbstract<ProductsTypeEnum, Integer> {
    
}
