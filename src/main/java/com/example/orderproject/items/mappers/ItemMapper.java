package com.example.orderproject.items.mappers;

import com.example.orderproject.items.Item;
import com.example.orderproject.items.dtos.CreateItemsDTO;
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
