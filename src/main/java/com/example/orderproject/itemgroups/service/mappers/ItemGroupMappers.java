package com.example.orderproject.itemgroups.service.mappers;

import com.example.orderproject.itemgroups.domain.ItemGroup;
import com.example.orderproject.itemgroups.domain.dtos.ItemGroupDetailsDTO;
import com.example.orderproject.items.domain.Item;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class ItemGroupMappers {

    public ItemGroup fromCreateItemGroupDTOToItemGroup(Integer amount, LocalDate shippingDate, Item item, BigDecimal unitPriceAtPurchase) {
        return new ItemGroup(amount, shippingDate, item, unitPriceAtPurchase);
    }

    public ItemGroupDetailsDTO fromItemGroupToItemGroupDetailsDTO(ItemGroup itemGroup) {
        return new ItemGroupDetailsDTO(
                itemGroup.getId(),
                itemGroup.getItem().getName(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate(),
                itemGroup.getUnitPriceAtPurchase(),
                itemGroup.getTotalPrice());
    }
}
