package com.example.orderproject.items.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "amount", nullable = false)
    private Integer amount;

    public Item(String name, String description, BigDecimal price, Integer amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    protected Item() {}

    public Integer getId() {
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
