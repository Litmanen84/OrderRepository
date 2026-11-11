package com.example.orderproject.orders.api.dtos;

import com.example.orderproject.itemgroups.domain.dtos.CreateItemGroupDTO;
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
