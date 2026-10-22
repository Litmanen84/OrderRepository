package com.example.orderproject.databases;

import com.example.orderproject.items.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ItemDB {
    private Logger logger = LoggerFactory.getLogger(UserDB.class);

    static Item testItem = new Item(
            "Orange",
            "Orange made by Ciccio",
            new BigDecimal("5.25"),
            10
    );

    private static List<Item> items = new ArrayList<>(List.of(testItem));

    public void save(Item item) {
        items.add(item);
        logger.info("Item saved: {}", item);
    }

    public boolean itemAlreadyExists(String name){
        return items.stream().anyMatch(item -> item.getName().equals(name));
    }

    public Optional<Item> getItemById(UUID id){
        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    public void clear(){
        items.clear();
    }

    public Item getTestItem(){
        return testItem;
    }

}
