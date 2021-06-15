package model.service;

import model.bean.Category;

import java.util.List;

public interface CategoryService {
    public Category findCategoryNameByID(int id);
    public List<Category> getAllCategoryName();

}
