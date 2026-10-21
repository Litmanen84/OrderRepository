package com.example.orderproject.orders;

import com.example.orderproject.itemgroups.dtos.CreateItemGroupDTO;
import com.example.orderproject.items.Item;
import com.example.orderproject.items.ItemService;
import com.example.orderproject.itemgroups.ItemGroup;
import com.example.orderproject.itemgroups.dtos.ItemGroupDetailsDTO;
import com.example.orderproject.itemgroups.mappers.ItemGroupMappers;
import com.example.orderproject.orders.dtos.CreateOrderDTO;
import com.example.orderproject.orders.dtos.OrderDetailsDTO;
import com.example.orderproject.users.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final ItemGroupMappers itemGroupMapper;

    public OrderService(OrderRepository orderRepository, ItemService itemService, ItemGroupMappers itemGroupMapper) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.itemGroupMapper = itemGroupMapper;
    }

    public OrderDetailsDTO createOrder(User user, CreateOrderDTO createOrderDTO) {
        List<ItemGroup> groups = new ArrayList<>();

        for (CreateItemGroupDTO itemGroup : createOrderDTO.getItems()) {
            Item item = itemService.getItemById(itemGroup.getItemId());
            boolean available = item.getAmount() >= itemGroup.getAmount();
            LocalDate shippingDate = LocalDate.now().plusDays(available ? 1 : 7);

            if (available) {
                item.setAmount(item.getAmount() - itemGroup.getAmount());
            }

            groups.add(itemGroupMapper.fromCreateItemGroupDTOToItemGroup(
                    user, itemGroup.getAmount(), item, shippingDate));
        }

        Order savedOrder = orderRepository.save(new Order(user, groups));
        List<ItemGroupDetailsDTO> details = savedOrder.getItemGroups().stream()
                .map(itemGroupMapper::fromItemGroupToItemGroupDetailsDTO)
                .toList();

        return new OrderDetailsDTO(savedOrder.getId(), details, savedOrder.getTotalPrice());
    }
}
