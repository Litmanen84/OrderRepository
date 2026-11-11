package com.example.orderproject.items.service;

import com.example.orderproject.items.repositories.ItemsRepository;
import com.example.orderproject.items.service.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemsRepository repo;
    private final ItemMapper mapper;

    ItemService(ItemsRepository repo, ItemMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

//    public void createItems(CreateItemsDTO items){
//        if (repo.itemAlreadyExists(items.getName())) {
//            throw new ItemAlreadyExistsException("Item already exists");
//        }
//        Item itemsToCreate = mapper.fromCreateItemDtoToItem(items);
//        repo.createItems(itemsToCreate);
//    }
//
//    public Item getItemById(UUID id){
//        return repo.getItemById(id)
//                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
//    }
}
