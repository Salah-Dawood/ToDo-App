package com.ga.todo.service;

import com.ga.todo.exception.InformationExistException;
import com.ga.todo.model.Category;
import com.ga.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //if using Autowire no need for the setter
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    //create service
    public Category createCategory(Category categoryObject) {
        System.out.println("Setvice Calling createCategory ==> ");

        Category category = categoryRepository.findByName(categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    //read services
    public List<Category> getCategories(){
        System.out.println("Service call getCategories() ==> ");
        return categoryRepository.findAll();
    }

    public Category getCategory(String category){
        System.out.println("Service calling getCategory() ==> ");
        return categoryRepository.findByName(category);
    }

}


