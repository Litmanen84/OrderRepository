package com.example.orderproject.items;

import com.example.orderproject.databases.ItemDB;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ItemRepository {
    private final ItemDB itemDB;

    public ItemRepository(ItemDB itemDB) {
        this.itemDB = itemDB;
    }

    public void createItems(Item items) {
        itemDB.save(items);
    }

    public boolean itemAlreadyExists(String name){
        return itemDB.itemAlreadyExists(name);
    }

    public Optional<Item> getItemById(UUID id){
        return itemDB.getItemById(id);
    }
}
