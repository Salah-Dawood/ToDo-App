package com.ga.todo.controller;

import com.ga.todo.model.Category;
import com.ga.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // GET's

    @GetMapping("/categories")
    public List<Category> getCategories(){
        System.out.println("calling getCategories() ==> ");
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{category}")
    public Category getCategory(@PathVariable String category){
        System.out.println("Calling getCategory() ==> ");
        return categoryService.getCategory(category);
    }

    // POST's

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject){
        System.out.println("Calling createCategory ==> ");

        return categoryService.createCategory(categoryObject);
    }

}
