package com.loomi.order_processing_system.infrastructure.exceptions;

public class EnumNotFoundException extends RuntimeException {
    
    public EnumNotFoundException(final String message) {
        super(message);
    }
    
    public EnumNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
}
