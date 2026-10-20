package com.example.orderproject.items;

import com.example.orderproject.items.dtos.CreateItemsDTO;
import com.example.orderproject.security.SecurityService;
import com.example.orderproject.users.enums.Feature;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItems(@Valid @RequestBody CreateItemsDTO createItemsDTO, @RequestHeader(value = "Authorization", required = false) String auth){
        security.validateAuthorization(auth, Feature.ADD_ITEM);
        itemService.createItems(createItemsDTO);
    }
}
