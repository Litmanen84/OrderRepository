package com.example.orderproject.items.api;

import com.example.orderproject.items.service.ItemService;
import com.example.orderproject.common.security.SecurityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final SecurityService security;
    private final ItemService itemService;

    public ItemController(SecurityService security, ItemService itemService) {
        this.security = security;
        this.itemService = itemService;
    }

//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createItems(@Valid @RequestBody CreateItemsDTO createItemsDTO, @RequestHeader(value = "Authorization", required = false) String auth){
//        security.validateAuthorization(auth, Feature.ADD_ITEM);
//        itemService.createItems(createItemsDTO);
//    }
}
