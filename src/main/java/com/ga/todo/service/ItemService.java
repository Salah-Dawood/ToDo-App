package com.ga.todo.service;

import com.ga.todo.exception.InformationNotFoundException;
import com.ga.todo.model.Category;
import com.ga.todo.model.Item;
import com.ga.todo.repository.CategoryRepository;
import com.ga.todo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    //create item
    public Item createItem(Long categoryId, Item item) {
        System.out.println("Service calling createItem()");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "Category with id " + categoryId + " not found"
                        ));
        item.setCategory(category);
        return itemRepository.save(item);
    }

    //get items by category
    public List<Item> getItemsByCategory(Long categoryId){
        System.out.println("Service calling getItemsByCategory");
        return itemRepository.findByCategoryId(categoryId);

    }

    //get item by ID
    public Optional<Item> getItemById(Long itemId){
        System.out.println("service calling getItemById");
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()){
            return item;
        } else {
            throw new InformationNotFoundException("Item with id " + itemId + " not found");
        }
    }

    //Update Item by ID
    public Item updateItem(Long itemId,Item itemObject){
        System.out.println("Service calling updateItem()");
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            Item updateRecipe = itemRepository.findById(itemId).get();
            updateRecipe.setName(itemObject.getName());
            updateRecipe.setDescription(itemObject.getDescription());
            updateRecipe.setDueDate(itemObject.getDueDate());
            return itemRepository.save(updateRecipe);
        } else {
            throw new InformationNotFoundException("Recipe with id " + itemId + " not found");
        }
    }

    //delete item by ID
    public Optional<Item> deleteItem(Long itemId){
        System.out.println("Service calling deleteItem()");
        Optional<Item> item = itemRepository.findById(itemId);

        if (item.isPresent()) {
            itemRepository.deleteById(itemId);
            return item;
        } else {
            throw new InformationNotFoundException("Recipe with id " + itemId + " not found");
        }
    }
}
