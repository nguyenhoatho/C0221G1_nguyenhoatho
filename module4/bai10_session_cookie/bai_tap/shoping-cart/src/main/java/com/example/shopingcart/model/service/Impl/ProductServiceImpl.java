package com.example.shopingcart.model.service.Impl;

import com.example.shopingcart.model.entity.Product;
import com.example.shopingcart.model.repository.IProductRepository;
import com.example.shopingcart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
