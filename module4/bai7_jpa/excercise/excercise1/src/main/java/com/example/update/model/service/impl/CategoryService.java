package com.example.update.model.service.impl;

import com.example.update.model.entity.Category;
import com.example.update.model.repository.CategoryRepository;
import com.example.update.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
//
        List<Category>categoryList=new ArrayList<>();
        for (Category category:categoryRepository.findAll()
             ) {
            if (category.getFlag()==1){
                categoryList.add(category);
            }

        }

        return categoryList;
    }

    @Override
    public void saveCategory(Category category) {
        category.setFlag(1);
        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(Integer id) {
        Category category=new Category();
        category=findById(id).get();
        category.setFlag(0);
        categoryRepository.save(category);
    }


    @Override
    public void editCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Integer id) {

        return categoryRepository.findById(id);
    }
}
