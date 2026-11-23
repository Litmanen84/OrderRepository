package com.example.orderproject.orders.api.dtos;

import com.example.orderproject.itemgroups.domain.dtos.ItemGroupDetailsDTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDetailsDTO {
    private final Integer orderId;
    private final List<ItemGroupDetailsDTO> items;
    private final BigDecimal totalPrice;

    public OrderDetailsDTO(Integer orderId, List<ItemGroupDetailsDTO> items, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.items = List.copyOf(items);
        this.totalPrice = totalPrice;
    }

    public Integer getOrderId() { return orderId; }
    public List<ItemGroupDetailsDTO> getItems() { return items; }
    public BigDecimal getTotalPrice() { return totalPrice; }
}
