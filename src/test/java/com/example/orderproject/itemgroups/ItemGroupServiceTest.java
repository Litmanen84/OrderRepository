package com.example.orderproject.itemgroups;

import com.example.orderproject.itemgroups.dtos.CreateItemGroupDTO;
import com.example.orderproject.itemgroups.dtos.ItemGroupDetailsDTO;
import com.example.orderproject.itemgroups.mappers.ItemGroupMappers;
import com.example.orderproject.items.Item;
import com.example.orderproject.items.ItemService;
import com.example.orderproject.users.Address;
import com.example.orderproject.users.BasicUser;
import com.example.orderproject.users.PhoneNumber;
import com.example.orderproject.users.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ItemGroupServiceTest {
    @Mock
    private ItemGroupRepository repo;

    @Mock
    private ItemGroupMappers igMapper;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemGroupService itemGroupService;

    @Test
    void createOrderCreatesOrder(){
        Item item = new Item(
                "Orange",
                "Delicious Oranges by Ciccio",
                new BigDecimal("5.20"),
                7
        );
        LocalDate today = LocalDate.now();
        LocalDate shippingDate = today.plusDays(1);
        User user = new BasicUser(
                "Ciccio",
                "Magnotta",
                "Ciccio@ciccio.com",
                "Ciccio123",
                new Address(
                        "Via vai",
                        23,
                        "Caserta",
                        "Italy",
                        "81100"
                ),
                new PhoneNumber(
                        "39",
                        "23456789"
                ));
        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(
                item.getId(),
                5
        );
        ItemGroup itemGroup = new ItemGroup(
                user,
                item,
                5,
                shippingDate
        );

        ItemGroupDetailsDTO expected = new ItemGroupDetailsDTO(
                itemGroup.getId(),
                itemGroup.getItemName(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate(),
                itemGroup.getUnitPriceAtPurchase(),
                itemGroup.getTotalPrice()
        );

        when(itemService.getItemById(item.getId())).thenReturn(item);
        when(igMapper.fromCreateItemGroupDTOToItemGroup(user, createItemGroupDTO.getAmount(), item, shippingDate)).thenReturn(itemGroup);
        when(repo.createOrder(itemGroup)).thenReturn(itemGroup);
        when(igMapper.fromItemGroupToItemGroupDetailsDTO(itemGroup)).thenReturn(expected);

        ItemGroupDetailsDTO actual =
                itemGroupService.createOrder(user, createItemGroupDTO);

        assertEquals(expected, actual);

        verify(repo).createOrder(itemGroup);
        verify(igMapper).fromItemGroupToItemGroupDetailsDTO(itemGroup);
        verify(itemService).getItemById(item.getId());
        assertEquals(2, (int) item.getAmount());
        verify(igMapper).fromCreateItemGroupDTOToItemGroup(user, createItemGroupDTO.getAmount(), item, shippingDate);
    }

    @Test
    void createOrderCreatesOrderWithShippingDateOneWeekLaterIfItemIsNotAvailable(){
        Item item = new Item(
                "Orange",
                "Delicious Oranges by Ciccio",
                new BigDecimal("5.20"),
                5
        );
        LocalDate today = LocalDate.now();
        LocalDate shippingDate = today.plusDays(7);
        User user = new BasicUser(
                "Ciccio",
                "Magnotta",
                "Ciccio@ciccio.com",
                "Ciccio123",
                new Address(
                        "Via vai",
                        23,
                        "Caserta",
                        "Italy",
                        "81100"
                ),
                new PhoneNumber(
                        "39",
                        "23456789"
                ));
        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(
                item.getId(),
                7
        );
        ItemGroup itemGroup = new ItemGroup(
                user,
                item,
                7,
                shippingDate
        );

        ItemGroupDetailsDTO expected = new ItemGroupDetailsDTO(
                itemGroup.getId(),
                itemGroup.getItemName(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate(),
                itemGroup.getUnitPriceAtPurchase(),
                itemGroup.getTotalPrice()
        );

        when(itemService.getItemById(item.getId())).thenReturn(item);
        when(igMapper.fromCreateItemGroupDTOToItemGroup(user, createItemGroupDTO.getAmount(), item, shippingDate)).thenReturn(itemGroup);
        when(repo.createOrder(itemGroup)).thenReturn(itemGroup);
        when(igMapper.fromItemGroupToItemGroupDetailsDTO(itemGroup)).thenReturn(expected);

        ItemGroupDetailsDTO actual =
                itemGroupService.createOrder(user, createItemGroupDTO);

        assertEquals(expected, actual);

        verify(repo).createOrder(itemGroup);
        verify(igMapper).fromItemGroupToItemGroupDetailsDTO(itemGroup);
        verify(itemService).getItemById(item.getId());
        assertEquals(5, (int) item.getAmount());
        verify(igMapper).fromCreateItemGroupDTOToItemGroup(user, createItemGroupDTO.getAmount(), item, shippingDate);
    }

}