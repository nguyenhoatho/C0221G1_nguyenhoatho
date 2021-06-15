package model.service.impl;

import model.bean.Category;
import model.repository.CategoryRepo;
import model.service.CategoryService;

import java.util.List;

public class CategoryServiceimlp implements CategoryService {
    CategoryRepo categoryRepo=new CategoryRepo();
    @Override
    public Category findCategoryNameByID(int id) {
        return categoryRepo.findCategoryNameByID(id) ;
    }

    @Override
    public List<Category> getAllCategoryName() {
        return categoryRepo.getAllCategory();
    }
}
