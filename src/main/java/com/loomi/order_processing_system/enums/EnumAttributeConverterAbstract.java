package com.loomi.order_processing_system.enums;

import java.lang.reflect.ParameterizedType;

import org.springframework.core.convert.converter.Converter;

import com.loomi.order_processing_system.utils.CastUtil;

import jakarta.persistence.AttributeConverter;

public abstract class EnumAttributeConverterAbstract<X extends EnumConverter<Y>, Y> implements AttributeConverter<X, Y>, Converter<String, X> {
    
    @Override
    public X convert(final String dbData) {
        return this.convertToEntityAttribute(CastUtil.cast(dbData));
    }
    
    @Override
    public final Y convertToDatabaseColumn(final X x) {
        return x != null ? x.getId() : null;
    }
    
    @Override
    public X convertToEntityAttribute(final Y dbData) {
        return EnumConverter.lookup(CastUtil.cast(((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]), dbData);
    }
    
    public X convertToEntityAttribute(final Class<X> classe, final Y dbData) {
        return EnumConverter.lookup(classe, dbData);
    }
    
}
