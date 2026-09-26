package com.ga.todo.service;

import com.ga.todo.exception.InformationExistException;
import com.ga.todo.exception.InformationNotFoundException;
import com.ga.todo.model.Category;
import com.ga.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Category> getCategory(long id){
        System.out.println("Service calling getCategory() ==> ");
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()){
            return category;
        } else {
            throw new InformationNotFoundException("Recipe with id " + id + " not found");
        }
    }

    // Update

    //update
    public Category updateCategory(long id,Category categoryObject){
        System.out.println("Service calling updateCategory()");
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category updateCategory = categoryRepository.findById(id).get();
            updateCategory.setName(categoryObject.getName());
            updateCategory.setDescription(categoryObject.getDescription());
            return categoryRepository.save(updateCategory);
        } else {
            throw new InformationNotFoundException("category with id " + id + " not found");
        }
    }

    //delete
    public Optional<Category> deleteCategory(Long id){
        System.out.println("Service calling deleteCategory()");

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + id + " not found");
        }
    }

}


