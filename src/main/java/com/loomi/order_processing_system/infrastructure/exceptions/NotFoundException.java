package com.loomi.order_processing_system.infrastructure.exceptions;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(final String message) {
        super(message);
    }
    
}
