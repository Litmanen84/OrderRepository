package com.example.orderproject.itemgroups.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.util.UUID;

public class CreateItemGroupDTO {
    @NotNull
    private UUID itemId;
    @NotNull
    @Min(1)
    private Integer amount;

    public CreateItemGroupDTO(UUID itemId, Integer amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public UUID getItemId() {
        return itemId;
    }
    public Integer getAmount() {
        return amount;
    }
}
