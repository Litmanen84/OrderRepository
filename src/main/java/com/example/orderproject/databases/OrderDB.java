package com.example.orderproject.databases;

import com.example.orderproject.orders.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDB {
    private final List<Order> orders = new ArrayList<>();

    public Order save(Order order) {
        orders.add(order);
        return order;
    }
}
