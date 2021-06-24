package com.example.update.model.service;

import com.example.update.model.entity.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();
    void saveCategory(Category category);
    void deleteCategory(Integer integer);
    void editCategory(Category category);
    Optional<Category> findById(Integer id);
}
