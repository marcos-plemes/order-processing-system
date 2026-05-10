package com.loomi.order_processing_system.infrastructure.exceptions;

public class BusinessException extends RuntimeException {
    
    public BusinessException(final String message) {
        super(message);
    }
    
}
