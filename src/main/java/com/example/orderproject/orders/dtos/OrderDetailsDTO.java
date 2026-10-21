package com.example.orderproject.orders.dtos;

import com.example.orderproject.itemgroups.dtos.ItemGroupDetailsDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderDetailsDTO {
    private final UUID orderId;
    private final List<ItemGroupDetailsDTO> items;
    private final BigDecimal totalPrice;

    public OrderDetailsDTO(UUID orderId, List<ItemGroupDetailsDTO> items, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.items = List.copyOf(items);
        this.totalPrice = totalPrice;
    }

    public UUID getOrderId() { return orderId; }
    public List<ItemGroupDetailsDTO> getItems() { return items; }
    public BigDecimal getTotalPrice() { return totalPrice; }
}
