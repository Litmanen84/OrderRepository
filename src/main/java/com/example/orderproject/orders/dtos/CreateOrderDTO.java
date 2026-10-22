package com.example.orderproject.orders.dtos;

import com.example.orderproject.itemgroups.dtos.CreateItemGroupDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderDTO {
    @NotEmpty
    @Valid
    private List<CreateItemGroupDTO> items = new ArrayList<>();

    public CreateOrderDTO(List<CreateItemGroupDTO> items) {
        this.items = items;
    }

    public List<CreateItemGroupDTO> getItems() { return items; }

}
