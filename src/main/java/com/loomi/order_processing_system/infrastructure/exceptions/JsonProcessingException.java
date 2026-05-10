package com.loomi.order_processing_system.infrastructure.exceptions;

public class JsonProcessingException extends RuntimeException {
    
    public JsonProcessingException(final String message) {
        super(message);
    }
    
}
