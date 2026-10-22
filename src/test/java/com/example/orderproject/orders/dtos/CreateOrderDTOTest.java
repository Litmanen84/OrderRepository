package com.example.orderproject.orders.dtos;

import com.example.orderproject.databases.ItemDB;
import com.example.orderproject.itemgroups.dtos.CreateItemGroupDTO;
import com.example.orderproject.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CreateOrderDTOTest {

    @Test
    void createOrderDTOCorrectlyCreatesAnOrderDTO() {
        ItemDB itemDB = new ItemDB();

        Item item = itemDB.getTestItem();
        CreateItemGroupDTO itemGroupDTO = new CreateItemGroupDTO(
                item.getId(),
                3
        );

        List<CreateItemGroupDTO> list = List.of(itemGroupDTO);
        CreateOrderDTO createOrderDTO = new CreateOrderDTO(list);
        assertNotNull(createOrderDTO);
        assertEquals(list, createOrderDTO.getItems());
    }


}