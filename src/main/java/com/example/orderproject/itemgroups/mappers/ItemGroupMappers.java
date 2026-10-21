package com.example.orderproject.itemgroups.mappers;

import com.example.orderproject.items.Item;
import com.example.orderproject.itemgroups.ItemGroup;
import com.example.orderproject.itemgroups.dtos.CreateItemGroupDTO;
import com.example.orderproject.itemgroups.dtos.ItemGroupDetailsDTO;
import com.example.orderproject.users.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemGroupMappers {

    public ItemGroup fromCreateItemGroupDTOToItemGroup(User user, Integer amount, Item item, LocalDate shippingDate) {
        return new ItemGroup(user, item, amount, shippingDate);
    }

    public ItemGroupDetailsDTO fromItemGroupToItemGroupDetailsDTO(ItemGroup itemGroup) {
        return new ItemGroupDetailsDTO(
                itemGroup.getId(),
                itemGroup.getItemName(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate(),
                itemGroup.getUnitPriceAtPurchase(),
                itemGroup.getTotalPrice());
    }
}
