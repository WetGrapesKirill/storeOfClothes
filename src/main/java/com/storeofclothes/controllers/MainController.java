package com.storeofclothes.controllers;

import com.storeofclothes.errorHandlers.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.storeofclothes.entities.*;
import com.storeofclothes.services.ItemService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class MainController {
    private final ItemService itemService;

    @Autowired
    public MainController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/addI")
    public @ResponseBody String addNewItem(@RequestParam String name, @RequestParam String specifications, @RequestParam float price){
        Item i = new Item();
        i.setName(name);
        i.setSpecifications(specifications);
        i.setPrice(price);
        itemService.save(i);
        return "Item saved";
    }

    @PostMapping(path = "/updI")
    public @ResponseBody String updateItem(@RequestParam int id, @RequestParam String name, @RequestParam String specifications, @RequestParam float price){
        Item i = itemService.getById(id);
        i.setName(name);
        i.setSpecifications(specifications);
        i.setPrice(price);
        itemService.save(i);
        return "Item updated";
    }

    @PostMapping(path = "/delI")
    public @ResponseBody String deleteItem(@RequestParam int id){
        itemService.delete(id);
        return "Item deleted";
    }

    @PostMapping(path = "/error")
    public @ResponseBody String errorHandler(){
        return "Something goes wrong";
    }

    @GetMapping(path = "/allI")
    public @ResponseBody List<Item> getAllItems(){
        if(itemService.findAll() == null){
            throw new ApiException("There is nothing to show", 404);
        }
        else
            return itemService.findAll();
    }
}
