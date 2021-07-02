package com.example.producti18n.model.service;

import com.example.producti18n.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void remove(Integer id);
    Product findById(Integer id);
    void update(Product product);
}
