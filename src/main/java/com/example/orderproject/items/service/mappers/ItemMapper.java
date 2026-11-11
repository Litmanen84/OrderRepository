package com.example.orderproject.items.service.mappers;

import com.example.orderproject.items.domain.Item;
import com.example.orderproject.items.api.dtos.CreateItemsDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item fromCreateItemDtoToItem(CreateItemsDTO createItemsDTO) {
        return new Item(
                createItemsDTO.getName(),
                createItemsDTO.getDescription(),
                createItemsDTO.getPrice(),
                createItemsDTO.getAmount()
        );
    }
}
