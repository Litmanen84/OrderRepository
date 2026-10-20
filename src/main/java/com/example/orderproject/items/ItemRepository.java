package com.example.orderproject.items;

import com.example.orderproject.databases.ItemDB;
import org.springframework.stereotype.Repository;

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
}
