package com.example.shopingcart.model.service;

import com.example.shopingcart.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

    void deleteById(Integer id);
}
