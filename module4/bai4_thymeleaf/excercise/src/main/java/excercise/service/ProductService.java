package excercise.service;

import excercise.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> PRODUCT_MAP;

    static {

        PRODUCT_MAP = new HashMap<>();
        PRODUCT_MAP.put(1, new Product("banh",1,455.3));
        PRODUCT_MAP.put(2, new Product("keo",2,4562.0));
        PRODUCT_MAP.put(3, new Product("bimbim",3,4565.0));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(PRODUCT_MAP.values());
    }

    @Override
    public void save(Product customer) {
        PRODUCT_MAP.put(customer.getIdProduct(), customer);
    }

    @Override
    public Product findById(int id) {
        return PRODUCT_MAP.get(id);
    }

    @Override
    public void update(int id, Product product) {
        PRODUCT_MAP.put(id, product);

    }

    @Override
    public void remove(int id) {
        PRODUCT_MAP.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList=new ArrayList<>();
        List<Product> productSearch=new ArrayList<>();
        Set set=PRODUCT_MAP.keySet();
        for (Object key:set){
            productList.add(PRODUCT_MAP.get(key));

        }
        for (Product product:productList) {
            if (product.getNameProduct().equals(name)){
                productSearch.add(product);
            }

        }
        return productSearch;
    }
}
