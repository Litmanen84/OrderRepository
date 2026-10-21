package com.example.orderproject.orders;

import com.example.orderproject.orders.dtos.CreateOrderDTO;
import com.example.orderproject.orders.dtos.OrderDetailsDTO;
import com.example.orderproject.security.SecurityService;
import com.example.orderproject.users.User;
import com.example.orderproject.users.enums.Feature;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetailsDTO createOrder(
            @Valid @RequestBody CreateOrderDTO createOrderDTO,
            @RequestHeader(value = "Authorization", required = false) String auth
    ) {
        User user = securityService.validateAuthorization(auth, Feature.CREATE_ORDER);
        return orderService.createOrder(user, createOrderDTO);
    }
}
