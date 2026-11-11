package com.example.orderproject.items.repositories;

import com.example.orderproject.items.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ItemsRepository {

    public void createItems(Item item) {
    }

    public boolean itemAlreadyExists(String name){
        return false;
    }

    public Optional<Item> getItemById(UUID id){
        return null;
    }
}
