package com.loomi.order_processing_system.infrastructure.exceptions;

import org.springframework.validation.BindingResult;

public class BindingException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final BindingResult results;
    
    public BindingException(final BindingResult results) {
        this.results = results;
    }
    
    public BindingResult getResults() {
        return this.results;
    }
    
}
