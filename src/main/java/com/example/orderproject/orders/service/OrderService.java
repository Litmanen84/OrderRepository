//package com.example.orderproject.orders.service;
//
//import com.example.orderproject.itemgroups.domain.ItemGroup;
//import com.example.orderproject.itemgroups.domain.dtos.CreateItemGroupDTO;
//import com.example.orderproject.itemgroups.domain.dtos.ItemGroupDetailsDTO;
//import com.example.orderproject.items.domain.Item;
//import com.example.orderproject.items.service.ItemService;
//import com.example.orderproject.itemgroups.service.mappers.ItemGroupMappers;
//import com.example.orderproject.orders.api.dtos.CreateOrderDTO;
//import com.example.orderproject.orders.api.dtos.OrderDetailsDTO;
//import com.example.orderproject.orders.domain.Orders;
//import com.example.orderproject.orders.repositories.OrderRepository;
//import com.example.orderproject.users.domain.User;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class OrderService {
//    private final OrderRepository orderRepository;
//    private final ItemService itemService;
//    private final ItemGroupMappers itemGroupMapper;
//
//    public OrderService(OrderRepository orderRepository, ItemService itemService, ItemGroupMappers itemGroupMapper) {
//        this.orderRepository = orderRepository;
//        this.itemService = itemService;
//        this.itemGroupMapper = itemGroupMapper;
//    }
//
//    public OrderDetailsDTO createOrder(User user, CreateOrderDTO createOrderDTO) {
//        List<ItemGroup> groups = new ArrayList<>();
//
//        for (CreateItemGroupDTO itemGroup : createOrderDTO.getItems()) {
//            Item item = itemService.getItemById(itemGroup.getItemId());
//            boolean available = item.getAmount() >= itemGroup.getAmount();
//            LocalDate shippingDate = LocalDate.now().plusDays(available ? 1 : 7);
//
//            if (available) {
//                item.setAmount(item.getAmount() - itemGroup.getAmount());
//            }
//
//            groups.add(itemGroupMapper.fromCreateItemGroupDTOToItemGroup(
//                    user, itemGroup.getAmount(), item, shippingDate));
//        }
//
//        Orders savedOrder = orderRepository.save(new Orders(user, groups));
//        List<ItemGroupDetailsDTO> details = savedOrder.getItemGroups().stream()
//                .map(itemGroupMapper::fromItemGroupToItemGroupDetailsDTO)
//                .toList();
//
//        return new OrderDetailsDTO(savedOrder.getId(), details, savedOrder.getTotalPrice());
//    }
//}
