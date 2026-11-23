package com.example.orderproject.orders.service;

import com.example.orderproject.itemgroups.domain.ItemGroup;
import com.example.orderproject.itemgroups.domain.dtos.CreateItemGroupDTO;
import com.example.orderproject.items.domain.Item;
import com.example.orderproject.items.service.ItemService;
import com.example.orderproject.itemgroups.service.mappers.ItemGroupMappers;
import com.example.orderproject.orders.api.dtos.CreateOrderDTO;
import com.example.orderproject.orders.api.dtos.OrderDetailsDTO;
import com.example.orderproject.orders.domain.Orders;
import com.example.orderproject.orders.repositories.OrderRepository;
import com.example.orderproject.orders.service.mappers.OrderMappers;
import com.example.orderproject.users.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final ItemGroupMappers itemGroupMapper;
    private final OrderMappers orderMappers;

    public OrderService(OrderRepository orderRepository, ItemService itemService, ItemGroupMappers itemGroupMapper, OrderMappers orderMappers) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.itemGroupMapper = itemGroupMapper;
        this.orderMappers = orderMappers;
    }

    @Transactional
    public OrderDetailsDTO createOrder(User user, CreateOrderDTO createOrderDTO) {

        Orders order = new Orders(user);
        List<CreateItemGroupDTO> items = createOrderDTO.getItems();

        for (CreateItemGroupDTO groupDTO : items) {

            Item item = itemService.getItemById(groupDTO.getItemId());

            boolean available = item.getAmount() >= groupDTO.getAmount();

            LocalDate shippingDate = LocalDate.now()
                    .plusDays(available ? 1 : 7);

            if (available) {
                item.setAmount(item.getAmount() - groupDTO.getAmount());
            }

            ItemGroup itemGroup = itemGroupMapper
                    .fromCreateItemGroupDTOToItemGroup(
                            groupDTO.getAmount(),
                            shippingDate,
                            item,
                            item.getPrice()
                    );

            order.addItemGroup(itemGroup);
        }

        Orders savedOrder = orderRepository.save(order);

        return orderMappers.fromOrderToOrderDetailsDto(savedOrder);
    }
}
