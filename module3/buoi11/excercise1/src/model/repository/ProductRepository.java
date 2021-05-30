package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    static Map<Integer, Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1,"loa",20000,"Yes","Japan"));
        productList.put(2, new Product(2,"may lanh",2200,"No","USA"));
        productList.put(3, new Product(3,"quat",1500,"Yes","France"));
        productList.put(4, new Product(4,"tv",4000,"No","Thailand"));
        productList.put(5, new Product(5,"may giat",60000,"Yes","China"));
    }



    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }


    public void save(Product product) {
        productList.put(product.getId(),product);
    }


    public Product findById(int id) {
        return productList.get(id);
    }


    public void update(int id,Product product) {
        productList.put(product.getId(),product);
    }


    public void remove(int id) {
        productList.remove(id);
    }

    public List<Product> findByName(String name) {
        List<Product> searhList = new ArrayList<>();
        List<Product> products = new ArrayList<>(productList.values());
        for(Product product : products){
            if(product.getName().equals(name)){
                searhList.add(product);
            }
        }

        return searhList;
    }
}
