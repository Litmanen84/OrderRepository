package com.example.orderproject.itemgroups;

import com.example.orderproject.databases.ItemDB;
import com.example.orderproject.databases.ItemGroupDB;
import com.example.orderproject.databases.UserDB;
import com.example.orderproject.items.Item;
import com.example.orderproject.users.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ItemGroupRepositoryTest {
    UserDB userDB = new UserDB();
    ItemDB itemDB = new ItemDB();

    @Test
    void createOrderCreatesOrder() {
        User user = userDB.getBasicUser();
        Item item = itemDB.getTestItem();
        ItemGroupDB itemGroupDB = new ItemGroupDB();
        ItemGroupRepository repo = new ItemGroupRepository(itemGroupDB);

        LocalDate shippingDate = LocalDate.now().plusDays(1);
        ItemGroup expected = new ItemGroup(
                user,
                item,
                5,
                shippingDate
        );

        ItemGroup actual = repo.createOrder(expected);
        assertEquals(expected, actual);
    }
}