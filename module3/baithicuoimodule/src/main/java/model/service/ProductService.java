package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    public boolean createProduct(Product product);
    public Product findProductByName(String id);
    public List<Product> getAllProduct();
    public boolean editProduct(Product product);
    public boolean deleteProduct(String id);
    public List<Product> searchProductByName(String name);
}
