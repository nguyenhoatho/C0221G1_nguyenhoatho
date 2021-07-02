package com.example.producti18n.model.service.Impl;

import com.example.producti18n.model.entity.Product;
import com.example.producti18n.model.repository.IProductRepository;
import com.example.producti18n.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }
}
