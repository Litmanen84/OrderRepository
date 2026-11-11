package com.example.orderproject.itemgroups.domain;

import com.example.orderproject.items.domain.Item;
import com.example.orderproject.orders.domain.Orders;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "item_groups")
public class ItemGroup {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "AMOUNT", nullable = false)
        private Integer amount;

        @Column(name = "SHIPPING_DATE", nullable = false)
        private LocalDate shippingDate;

        @Column(name = "UNIT_PRICE", nullable = false,
                precision = 10, scale = 2)
        private BigDecimal unitPriceAtPurchase;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ITEMS_ID", nullable = false)
        private Item item;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ORDERS_ID", nullable = false)
        private Orders order;

        protected ItemGroup() {
        }

        public ItemGroup(Integer amount, LocalDate shippingDate,
                         Item item,
                         BigDecimal unitPriceAtPurchase) {
            this.amount = amount;
            this.shippingDate = shippingDate;
            this.item = item;
            this.unitPriceAtPurchase = unitPriceAtPurchase;
        }

        public BigDecimal getTotalPrice() {
            return unitPriceAtPurchase.multiply(
                    BigDecimal.valueOf(amount)
            );
        }

        public void setOrder(Orders order) {
            this.order = order;
        }

        public Integer getId() {
            return id;
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

        public Item getItem() {
            return item;
        }

        public Orders getOrder() {
            return order;
        }
}
