package com.example.shopingcart.model.service.Impl;

import com.example.shopingcart.model.entity.Product;
import com.example.shopingcart.model.repository.IProductRepository;
import com.example.shopingcart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
