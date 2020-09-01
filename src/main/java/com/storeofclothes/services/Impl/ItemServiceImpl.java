package com.storeofclothes.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.storeofclothes.entities.Item;
import com.storeofclothes.repositories.ItemRepository;
import com.storeofclothes.services.ItemService;

import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.saveAndFlush(item);
    }

    @Override
    public void delete(int idOfItem) {
        itemRepository.deleteById(idOfItem);
    }

    @Override
    public Item getById(int idOfItem) {
        return itemRepository.getById(idOfItem);
    }

    @Override
    public Item getByName(String nameOfItem) {
        return itemRepository.findByName(nameOfItem);
    }
}
