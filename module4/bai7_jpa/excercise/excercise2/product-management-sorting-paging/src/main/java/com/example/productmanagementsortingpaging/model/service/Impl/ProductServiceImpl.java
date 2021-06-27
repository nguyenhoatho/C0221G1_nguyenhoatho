package com.example.productmanagementsortingpaging.model.service.Impl;

import com.example.productmanagementsortingpaging.model.entity.Product;
import com.example.productmanagementsortingpaging.model.repository.IProductRepository;
import com.example.productmanagementsortingpaging.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<Product> findAll(String nameSearch ,Pageable pageable) {
        return productRepository.findAllByNameSearch(nameSearch,pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

//    @Override
//    public List<Product> seachProduct(String name) {
//        return productRepository.seachProduct(name);
//    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);

    }
}
