package com.example.orderproject.itemgroups.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemGroupDetailsDTO {
    private Integer itemGroupId;
    private String itemName;
    private Integer amount;
    private LocalDate shippingDate;
    private BigDecimal unitPriceAtPurchase;
    private BigDecimal totalPrice;

    public ItemGroupDetailsDTO(Integer itemGroupId, String itemName, Integer amount, LocalDate shippingDate, BigDecimal unitPriceAtPurchase, BigDecimal totalPrice) {
        this.itemGroupId = itemGroupId;
        this.itemName = itemName;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.unitPriceAtPurchase = unitPriceAtPurchase;
        this.totalPrice = totalPrice;
    }

    public Integer getItemGroupId() {
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
