package com.ga.todo.repository;

import com.ga.todo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById(Long itemId);
    Item findByName(String itemName);
    List<Item> findByCategoryId(Long categoryId);
}
