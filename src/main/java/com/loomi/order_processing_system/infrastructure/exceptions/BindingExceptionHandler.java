package com.loomi.order_processing_system.infrastructure.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BindingExceptionHandler {
    
    @ExceptionHandler(BindingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handle(
            final BindingException ex
                                     ) {
        
        final Map<String, String> errors =
                new HashMap<>();
        
        ex.getResults()
          .getFieldErrors()
          .forEach(error ->
                           
                           errors.put(
                                   error.getField(),
                                   error.getDefaultMessage()
                                     )
                  );
        
        return Map.of(
                "status", 400,
                "errors", errors
                     );
    }
    
}
