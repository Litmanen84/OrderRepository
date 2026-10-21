package com.example.orderproject.itemgroups.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupDetailsDTO {
    private UUID itemGroupId;
    private String itemName;
    private Integer amount;
    private LocalDate shippingDate;
    private BigDecimal unitPriceAtPurchase;
    private BigDecimal totalPrice;

    public ItemGroupDetailsDTO(UUID itemGroupId, String itemName, Integer amount, LocalDate shippingDate, BigDecimal unitPriceAtPurchase, BigDecimal totalPrice) {
        this.itemGroupId = itemGroupId;
        this.itemName = itemName;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.unitPriceAtPurchase = unitPriceAtPurchase;
        this.totalPrice = totalPrice;
    }

    public UUID getItemGroupId() {
        return itemGroupId;
    }
    public String getItemName() {
        return itemName;
    }
    public Integer getAmount() {
        return amount;
    }
    public LocalDate getShippingDate() {
        return shippingDate;
    }
    public BigDecimal getUnitPriceAtPurchase() {
        return unitPriceAtPurchase;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
