package com.loomi.order_processing_system.adapters.in;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loomi.order_processing_system.application.dto.orders.CreateOrderRequest;
import com.loomi.order_processing_system.application.dto.orders.CreateOrderResponse;
import com.loomi.order_processing_system.application.usecases.CreateOrderUseCase;
import com.loomi.order_processing_system.infrastructure.exceptions.BindingException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    
    private final CreateOrderUseCase createOrderUseCase;
    
    public OrdersController(final CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }
    
    @PostMapping
    public CreateOrderResponse createOrder(
            @Valid @RequestBody final CreateOrderRequest createOrderRequest,
            final BindingResult results) throws BindingException {
        if (results.hasErrors()) {
            throw new BindingException(results);
        }
        return this.createOrderUseCase.createOrder(createOrderRequest);
    }
    
}
