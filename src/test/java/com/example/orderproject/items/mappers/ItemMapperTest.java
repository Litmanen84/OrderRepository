package com.example.orderproject.items.mappers;

import com.example.orderproject.items.service.mappers.ItemMapper;

class ItemMapperTest {

    ItemMapper mapper = new ItemMapper();

//    @Test
//    void fromCreateItemDtoToItemCorrectlyMapsFields() {
//        CreateItemsDTO item = new CreateItemsDTO(
//                "Orange",
//                "Ciccio",
//                new BigDecimal("5.25"),
//                7
//        );
//        Item newItem = mapper.fromCreateItemDtoToItem(item);
//        assertNotNull(newItem);
//        assertAll(
//                () -> assertEquals(item.getName(), newItem.getName()),
//                () -> assertEquals(item.getDescription(), newItem.getDescription()),
//                () -> assertEquals(item.getPrice(), newItem.getPrice()),
//                () -> assertEquals(item.getAmount(), newItem.getAmount())
//        );
//
//    }
}