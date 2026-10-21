package com.example.orderproject.orders;

import com.example.orderproject.databases.OrderDB;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final OrderDB orderDB;

    public OrderRepository(OrderDB orderDB) {
        this.orderDB = orderDB;
    }

    public Order save(Order order) {
        return orderDB.save(order);
    }
}
