package com.storeofclothes.services;
import com.storeofclothes.entities.Item;

import java.util.List;

public interface ItemService{
    List<Item> findAll();

    Item  save(Item item);

    Item update(Item item);

    void delete(int idOfItem);

    Item getById(int idOfItem);

    Item getByName(String nameOfItem);
}
