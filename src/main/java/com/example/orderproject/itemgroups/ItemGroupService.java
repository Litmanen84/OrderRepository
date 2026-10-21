package com.example.orderproject.itemgroups;

import com.example.orderproject.items.Item;
import com.example.orderproject.items.ItemService;
import com.example.orderproject.itemgroups.dtos.CreateItemGroupDTO;
import com.example.orderproject.itemgroups.dtos.ItemGroupDetailsDTO;
import com.example.orderproject.itemgroups.mappers.ItemGroupMappers;
import com.example.orderproject.users.User;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ItemGroupService {
    private static final Logger log = LoggerFactory.getLogger(ItemGroupService.class);
    private final ItemGroupRepository itemGroupRepository;
    private final ItemService itemService;
    private final ItemGroupMappers igMapper;

    public ItemGroupService(ItemGroupRepository itemGroupRepository, ItemService itemService, ItemGroupMappers igMapper) {
        this.itemGroupRepository = itemGroupRepository;
        this.itemService = itemService;
        this.igMapper = igMapper;
    }

    public ItemGroupDetailsDTO createOrder(User user, CreateItemGroupDTO createItemGroupDTO) {
        Item item = itemService.getItemById(createItemGroupDTO.getItemId());
        LocalDate shippingDate = calculateShippingDate(item, createItemGroupDTO.getAmount());
        ItemGroup itemGroup = igMapper.fromCreateItemGroupDTOToItemGroup(user, createItemGroupDTO.getAmount(), item, shippingDate);
        return igMapper.fromItemGroupToItemGroupDetailsDTO(itemGroupRepository.createOrder(itemGroup));
    }

    private LocalDate calculateShippingDate(Item item, Integer amount) {
        LocalDate shippingDate;
        if(item.getAmount() >= amount) {
            item.setAmount(item.getAmount() - amount);
            shippingDate = LocalDate.now().plusDays(1);
        } else {
            shippingDate = LocalDate.now().plusDays(7);
        }
        return shippingDate;
    }
}
