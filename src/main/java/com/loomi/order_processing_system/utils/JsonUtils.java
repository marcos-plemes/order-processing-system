package com.loomi.order_processing_system.utils;

import java.util.Map;

import com.loomi.order_processing_system.infrastructure.exceptions.JsonProcessingException;

import tools.jackson.databind.ObjectMapper;

public class JsonUtils {
    
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    public static String toJson(final Map<String, Object> map) {
        try {
            return OBJECT_MAPPER.writeValueAsString(map);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter Map para JSON", e);
        }
    }
    
}
