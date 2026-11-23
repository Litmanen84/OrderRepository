package com.example.orderproject.orders.service.mappers;

import com.example.orderproject.itemgroups.service.mappers.ItemGroupMappers;
import com.example.orderproject.orders.api.dtos.OrderDetailsDTO;
import com.example.orderproject.orders.domain.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrderMappers {
    private final ItemGroupMappers itemGroupMappers;

    public OrderMappers(ItemGroupMappers itemGroupMappers) {
        this.itemGroupMappers = itemGroupMappers;
    }

    public OrderDetailsDTO fromOrderToOrderDetailsDto (Orders order){
        return new OrderDetailsDTO(
                order.getId(),
                order.getItemGroups().stream()
                        .map(itemGroupMappers::fromItemGroupToItemGroupDetailsDTO)
                        .toList(),
                order.getOrderPrice()
        );
    }
}
