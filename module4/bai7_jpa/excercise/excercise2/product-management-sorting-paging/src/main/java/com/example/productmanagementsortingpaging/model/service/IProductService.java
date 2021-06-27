package com.example.productmanagementsortingpaging.model.service;

import com.example.productmanagementsortingpaging.model.entity.Product;
import com.example.productmanagementsortingpaging.model.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> findAll(String nameSearch,Pageable pageable);


    void save(Product product);


    Product findById(int id);




    void update(Product product);


    void remove(int id);
}
