package com.loomi.order_processing_system.utils;

public class CastUtil {
    
    private CastUtil() {}
    
    @SuppressWarnings("unchecked")
    public static <T> T cast(final Object object) {
        return (T) object;
    }
    
}
