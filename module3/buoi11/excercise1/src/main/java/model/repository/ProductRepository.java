package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
 static Map<Integer, Product>productMap=new HashMap<>();
 static {
     productMap.put(1,new Product(1,"banh","14-3-2021","14-03-2022","viet nam"));
     productMap.put(2,new Product(2,"keo","14-3-2021","14-03-2022","viet nam"));
     productMap.put(3,new Product(3,"oishi","14-3-2021","14-03-2022","viet nam"));
     productMap.put(4,new Product(4,"snack","14-3-2021","14-03-2022","viet nam"));
 }
 public List<Product> findByAll(){
     return new ArrayList<>(productMap.values());
 }
 public void add(Product product){
     productMap.put(product.getId(),product);

 }
 public void view(int id){
     productMap.get(id);

 }
 public void update(int id,Product product){
    productMap.put(product.getId(), product);
 }
 public List<Product> findByName(String name){
     List<Product> searchList=new ArrayList<>();
     List<Product> productList=new ArrayList<>(productMap.values());
     for (Product product:productList){
         if (product.equals(name)){
             searchList.add(product);

         }

     }
     return searchList;


 }
 public void delete (int id){
    productMap.remove(id);
 }


}
