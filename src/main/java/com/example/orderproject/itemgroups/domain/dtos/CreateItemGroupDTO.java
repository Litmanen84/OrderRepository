package com.example.orderproject.itemgroups.domain.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public class CreateItemGroupDTO {
    private Integer itemId;
    @NotNull
    @Min(1)
    private Integer amount;

    public CreateItemGroupDTO(Integer itemId, Integer amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public Integer getItemId() {
        return itemId;
    }
    public Integer getAmount() {
        return amount;
    }
}
