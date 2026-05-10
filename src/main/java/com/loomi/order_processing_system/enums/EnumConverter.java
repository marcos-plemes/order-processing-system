package com.loomi.order_processing_system.enums;

import java.util.stream.Stream;

import org.springframework.util.StringUtils;

import com.loomi.order_processing_system.infrastructure.exceptions.EnumNotFoundException;

public interface EnumConverter<T> {
    
    static <E extends EnumConverter<T>, T> E lookup(final Class<E> classe, final T id) {
        if (id == null || (id instanceof String && StringUtils.isEmpty(((String) id).trim()))) {
            return null;
        }
        
        return Stream.of(classe.getEnumConstants())
                     .filter(e -> enumEquals(id, e))
                     .findFirst()
                     .orElseThrow(() -> new EnumNotFoundException(String.format("No enum value found for code '%s' in %s", id, classe.getSimpleName())));
    }
    
    private static <E extends EnumConverter<T>, T> boolean enumEquals(final T id, final E e) {
        return String.valueOf(e.getId()).equals(String.valueOf(id));
    }
    
    T getId();
    
}
