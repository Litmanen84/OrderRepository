package com.example.orderproject.orders.dtos;

import com.example.orderproject.databases.ItemDB;
import com.example.orderproject.databases.UserDB;
import com.example.orderproject.itemgroups.ItemGroup;
import com.example.orderproject.itemgroups.dtos.ItemGroupDetailsDTO;
import com.example.orderproject.itemgroups.mappers.ItemGroupMappers;
import com.example.orderproject.items.Item;
import com.example.orderproject.users.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailsDTOTest {
    UserDB userDB = new UserDB();
    ItemDB itemDB = new ItemDB();
    ItemGroupMappers itemGroupMapper = new ItemGroupMappers();

    @Test
    void orderDetailsDTOCorrectlyCreatesAnOrderDetailsDTO() {
        User user = userDB.getBasicUser();
        Item item = itemDB.getTestItem();
        UUID itemId = item.getId();
        LocalDate shippingDate = LocalDate.now().plusDays(1);
        ItemGroup itemGroup = new ItemGroup(user, item, 3, shippingDate);
        BigDecimal totalPrice = itemGroup.getTotalPrice();
        ItemGroupDetailsDTO itemGroupDetailsDTO = itemGroupMapper.fromItemGroupToItemGroupDetailsDTO(itemGroup);
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO(itemId, List.of(itemGroupDetailsDTO), totalPrice);
        assertNotNull(orderDetailsDTO);
        assertEquals(itemId, orderDetailsDTO.getOrderId());
        assertEquals(List.of(itemGroupDetailsDTO), orderDetailsDTO.getItems());
        assertEquals(totalPrice, orderDetailsDTO.getTotalPrice());
    }
}