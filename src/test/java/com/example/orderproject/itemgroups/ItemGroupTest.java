package com.example.orderproject.itemgroups;

import com.example.orderproject.databases.ItemDB;
import com.example.orderproject.databases.UserDB;
import com.example.orderproject.items.Item;
import com.example.orderproject.users.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ItemGroupTest {
    UserDB userDB = new UserDB();
    ItemDB itemDB = new ItemDB();

    @Test
    void itemGroupConstructorCreatesItemGroup(){
        User user = userDB.getBasicUser();
        Item item = itemDB.getTestItem();
        LocalDate shippingDate = LocalDate.now().plusDays(1);
        ItemGroup itemGroup = new ItemGroup(user, item, 3, shippingDate);
        assertNotNull(itemGroup);
        assertTrue(itemGroup.getId() != null);
        assertEquals(user, itemGroup.getUser());
        assertEquals(item.getName(), itemGroup.getItemName());
        assertEquals(item.getId(), itemGroup.getItemId());
        assertEquals(3, itemGroup.getAmount());
        assertEquals(shippingDate, itemGroup.getShippingDate());
        assertEquals(item.getPrice(), itemGroup.getUnitPriceAtPurchase());
        assertEquals(item.getPrice().multiply(new BigDecimal(3)), itemGroup.getTotalPrice());
    }
}