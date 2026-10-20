package com.example.orderproject.items.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CreateItemsDTO {
    @NotBlank
    private String name;
    private String description;
    @DecimalMin("0.01")
    @NotNull
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;
    @NotNull
    @Min(1)
    private Integer amount;

    public CreateItemsDTO(String name, String description, BigDecimal price, Integer amount) {
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
