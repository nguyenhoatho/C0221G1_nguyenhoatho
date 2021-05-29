package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.ProductService;

import java.util.List;

public class ProductImp implements ProductService {
    ProductRepository productRepository=new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findByAll();
    }

    @Override
    public void save(Product product) {
           productRepository.add(product);

    }

    @Override
    public Product findById(int id) {
        return productRepository.view(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id,product);

    }

    @Override
    public void remove(int id) {
        productRepository.delete(id);

    }

    @Override
    public List<Product> findByName(String Name) {
       return productRepository.findByName(Name);
    }

    }
