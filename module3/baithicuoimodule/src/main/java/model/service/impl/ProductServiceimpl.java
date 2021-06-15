package model.service.impl;

import model.bean.Product;
import model.service.ProductService;

import java.util.List;

public class ProductServiceimpl implements ProductService {
    @Override
    public boolean createProduct(Product product) {
        return false;
    }

    @Override
    public Product findProductByNmae(String id) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public boolean editProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        return false;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }
}
