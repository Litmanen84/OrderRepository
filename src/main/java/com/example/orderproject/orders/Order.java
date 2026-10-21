package com.example.orderproject.orders;

import com.example.orderproject.itemgroups.ItemGroup;
import com.example.orderproject.users.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final User user;
    private final List<ItemGroup> itemGroups;
    private final BigDecimal totalPrice;

    public Order(User user, List<ItemGroup> itemGroups) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.itemGroups = List.copyOf(itemGroups);
        this.totalPrice = itemGroups.stream()
                .map(ItemGroup::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public UUID getId() { return id; }
    public User getUser() { return user; }
    public List<ItemGroup> getItemGroups() { return itemGroups; }
    public BigDecimal getTotalPrice() { return totalPrice; }
}
