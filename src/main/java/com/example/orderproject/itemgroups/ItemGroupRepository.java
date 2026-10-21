package com.example.orderproject.itemgroups;

import com.example.orderproject.databases.ItemGroupDB;
import org.springframework.stereotype.Repository;

@Repository
public class ItemGroupRepository {
    private ItemGroupDB itemGroupDB;

    public ItemGroupRepository(ItemGroupDB itemGroupDB) {
        this.itemGroupDB = itemGroupDB;
    }

    public ItemGroup createOrder(ItemGroup itemGroup) {
        return itemGroupDB.save(itemGroup);
    }
}
