package com.example.orderproject.items.service;

import com.example.orderproject.common.exceptions.ItemAlreadyExistsException;
import com.example.orderproject.common.exceptions.ItemNotFoundException;
import com.example.orderproject.items.api.dtos.CreateItemsDTO;
import com.example.orderproject.items.domain.Item;
import com.example.orderproject.items.repositories.ItemsRepository;
import com.example.orderproject.items.service.mappers.ItemMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemsRepository repo;
    private final ItemMapper mapper;

    ItemService(ItemsRepository repo, ItemMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional
    public void createItem(CreateItemsDTO items){
        if (repo.existsByName(items.getName())) {
            throw new ItemAlreadyExistsException("Item already exists");
        }
        Item item = mapper.fromCreateItemDtoToItem(items);
        repo.save(item);
    }

    public Item getItemById(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }
}
