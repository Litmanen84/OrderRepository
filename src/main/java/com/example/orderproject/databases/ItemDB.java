package com.example.orderproject.databases;

import com.example.orderproject.items.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDB {
    private static List<Item> items = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(UserDB.class);

    public void save(Item item) {
        items.add(item);
        logger.info("Item saved: {}", item);
    }

    public boolean itemAlreadyExists(String name){
        return items.stream().anyMatch(item -> item.getName().equals(name));
    }


    public void clear(){
        items.clear();
    }

}
