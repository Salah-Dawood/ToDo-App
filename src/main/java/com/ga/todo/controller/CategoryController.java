package com.ga.todo.controller;

import com.ga.todo.model.Category;
import com.ga.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/categories/{id}")
    public Optional<Category> getCategory(@PathVariable long id){
        System.out.println("Calling getCategory() ==> ");
        return categoryService.getCategory(id);
    }

    // POST's

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject){
        System.out.println("Calling createCategory ==> ");

        return categoryService.createCategory(categoryObject);
    }

    // PUT's

    //UPDATE
    @PutMapping(value = "/categories/{id}")
    public Category updateCategory(@PathVariable long id,
                                   @RequestBody Category categoryObject){
        System.out.println("Calling updateCategory()");
        return categoryService.updateCategory(id,categoryObject);
    }

    //DELETE
    @DeleteMapping("/categories/{id}")
    public Optional<Category> deleteCategory(@PathVariable Long id){
        System.out.println("Calling deleteCategory()");
        return categoryService.deleteCategory(id);
    }
}
