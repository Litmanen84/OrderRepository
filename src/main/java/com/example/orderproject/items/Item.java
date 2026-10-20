package com.example.orderproject.items;

import java.math.BigDecimal;

public class Item {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public Item(String name, String description, BigDecimal price, Integer amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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
}
