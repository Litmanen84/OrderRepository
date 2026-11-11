package com.example.orderproject.orders.domain;

import com.example.orderproject.itemgroups.domain.ItemGroup;
import com.example.orderproject.users.domain.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_price", nullable = false,
            precision = 10, scale = 2)
    private BigDecimal orderPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS_ID", nullable = false)
    private User user;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemGroup> itemGroups = new ArrayList<>();


    public Orders(User user) {
        this.user = user;
        this.createdAt = Instant.now();
        this.orderPrice = BigDecimal.ZERO;
    }

    protected Orders() {
    }

    public void addItemGroup(ItemGroup itemGroup) {
        if (itemGroup == null) {
            throw new IllegalArgumentException("ItemGroup cannot be null");
        }

        if (itemGroups.contains(itemGroup)) {
            return;
        }

        itemGroups.add(itemGroup);
        itemGroup.setOrder(this);
        recalculateOrderPrice();
    }

    private void recalculateOrderPrice() {
        this.orderPrice = itemGroups.stream()
                .map(ItemGroup::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<ItemGroup> getItemGroups() { return List.copyOf(itemGroups); }

    public Integer getId() { return id; }
    public User getUser() { return user; }

    public BigDecimal getOrderPrice() { return orderPrice; }
    public Instant getCreatedAt() { return createdAt; }

}
