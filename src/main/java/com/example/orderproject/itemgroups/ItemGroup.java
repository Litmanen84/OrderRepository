package com.example.orderproject.itemgroups;

import com.example.orderproject.items.Item;
import com.example.orderproject.users.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static java.math.BigDecimal.valueOf;

public class ItemGroup {
    private final UUID id;
    private final User user;
    private final String itemName;
    private final UUID itemId;
    private final Integer amount;
    private final LocalDate shippingDate;
    private final BigDecimal unitPriceAtPurchase;
    private final BigDecimal totalPrice;

    public ItemGroup(User user, Item item, Integer amount, LocalDate shippingDate) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.itemName = item.getName();
        this.itemId = item.getId();
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.unitPriceAtPurchase = item.getPrice();
        this.totalPrice = item.getPrice().multiply(valueOf(amount));
    }

    public UUID getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public String getItemName() {
        return itemName;
    }
    public UUID getItemId() {
        return itemId;
    }
    public Integer getAmount() {
        return amount;
    }
    public LocalDate getShippingDate() {
        return shippingDate;
    }
    public BigDecimal getUnitPriceAtPurchase() {
        return unitPriceAtPurchase;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
