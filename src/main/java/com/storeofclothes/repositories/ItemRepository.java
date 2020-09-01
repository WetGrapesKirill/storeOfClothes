package com.storeofclothes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.storeofclothes.entities.Item;

@Repository(value = "ItemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
    Item getById(int id);
    void deleteById(int id);
}
