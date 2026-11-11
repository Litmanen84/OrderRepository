package com.example.orderproject.items;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.orderproject.items.repositories.ItemsRepository;
import com.example.orderproject.items.service.ItemService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemsRepository repo;

    @InjectMocks
    private ItemService itemService;

//    @Test
//    void createItemsWithAlreadyExistingItem_throwsException() {
//        CreateItemsDTO test = new CreateItemsDTO("test", "test", new BigDecimal("10.0"), 10);
//        when(repo.itemAlreadyExists("test")).thenReturn(true);
//        assertThrows(ItemAlreadyExistsException.class,
//                () -> itemService.createItems(test)
//        );
//    }
}