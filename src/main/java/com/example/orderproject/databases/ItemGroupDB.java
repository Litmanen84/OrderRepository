package com.example.orderproject.databases;

import com.example.orderproject.itemgroups.ItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemGroupDB {
    private static List<ItemGroup> itemGroups = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(UserDB.class);

    public ItemGroup save(ItemGroup itemGroup) {
        itemGroups.add(itemGroup);
        logger.info("Order saved: {}", itemGroup);
        return itemGroup;
    }
}
