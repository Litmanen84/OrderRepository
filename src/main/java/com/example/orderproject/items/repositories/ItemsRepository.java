package com.example.orderproject.items.repositories;

import com.example.orderproject.items.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    boolean existsByName(String name);
}
