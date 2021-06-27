package com.example.update.model.service;

import com.example.update.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    void saveCategory(Category category);
    void deleteCategory(Integer id);
    void editCategory(Category category);
    Optional<Category> findById(Integer id);
}
