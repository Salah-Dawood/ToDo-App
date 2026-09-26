package com.ga.todo.controller;

import com.ga.todo.model.Item;
import com.ga.todo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;


    //POST's

    @PostMapping("/{categoryId}/items")
    public Item createItem(
            @PathVariable( value = "categoryId") Long categoryId,
            @RequestBody Item itemObject){
        System.out.println("calling createItem()");
        return itemService.createItem(categoryId,itemObject);
    }

    // GET's

    @GetMapping("/{categoryId}/items")
    public List<Item> getItemsByCategory(
            @PathVariable( value = "categoryId") Long categoryId){
        System.out.println("calling getItemsByCategory()");
        return itemService.getItemsByCategory(categoryId);
    }

    @GetMapping("/{categoryId}/items/{itemId}")
    public Optional<Item> getItemById(
            @PathVariable Long itemId){
        System.out.println("calling getItemById");
        return itemService.getItemById(itemId);
    }

    //PUT's
    @PutMapping("/{categoryId}/items/{itemId}")
    public Item updateItem(
            @PathVariable Long itemId,
            @RequestBody Item itemObject){
        System.out.println("calling updateItem()");
        return itemService.updateItem(itemId,itemObject);
    }

    //DELETE's
    @DeleteMapping("/{categoryId}/items/{itemId}")
    public Optional<Item> deleteItem(
            @PathVariable Long itemId){
        System.out.println("calling deleteItem()");
        return itemService.deleteItem(itemId);
    }
}
