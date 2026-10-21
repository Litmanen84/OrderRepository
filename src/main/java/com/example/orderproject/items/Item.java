package com.example.orderproject.items;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
    private final UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public Item(String name, String description, BigDecimal price, Integer amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
