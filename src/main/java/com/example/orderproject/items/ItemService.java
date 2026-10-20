package com.example.orderproject.items;

import com.example.orderproject.exceptions.ItemAlreadyExistsException;
import com.example.orderproject.items.dtos.CreateItemsDTO;
import com.example.orderproject.items.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository repo;
    private final ItemMapper mapper;

    ItemService(ItemRepository repo, ItemMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public void createItems(CreateItemsDTO items){
        if (repo.itemAlreadyExists(items.getName())) {
            throw new ItemAlreadyExistsException("Item already exists");
        }
        Item itemsToCreate = mapper.fromCreateItemDtoToItem(items);
        repo.createItems(itemsToCreate);
    }

}
