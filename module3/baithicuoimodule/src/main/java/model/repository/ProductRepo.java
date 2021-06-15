package model.repository;

import model.BaseRepository;
import model.bean.Category;
import model.bean.Product;
import model.service.CategoryService;
import model.service.impl.CategoryServiceimlp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    BaseRepository baseRepository=new BaseRepository();
    CategoryService categoryService=new CategoryServiceimlp();

    public Product findProductByID(String inputID) {
        Connection connection = baseRepository.connectDatabase();
        Product product = null;
        String query="select * from product.product where id_product=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inputID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID =Integer.parseInt( resultSet.getString("id_product"));
                int categoryID = resultSet.getInt("id_categroy");
                String productName = resultSet.getString("name_product");
                String productPrice = resultSet.getString("price_product");
                String productAmout = resultSet.getString("amout_product");
                String descriptionProduct = resultSet.getString("description_product");
                Category categoryName = categoryService.findCategoryNameByID(categoryID);
//                public Product(int productId, String productName, String productPrice, String productAmount, String productDescription, Category categoryName)
                product = new Product(productID,productName, productPrice, productAmout, productAmout, descriptionProduct,categoryName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getAllCustomer() {
        Connection connection = baseRepository.connectDatabase();
        String query="SELECT * FROM product.product;";
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID =Integer.parseInt( resultSet.getString("id_product"));
                int categoryID = resultSet.getInt("id_categroy");
                String productName = resultSet.getString("name_product");
                String productPrice = resultSet.getString("price_product");
                String productAmout = resultSet.getString("amout_product");
                String descriptionProduct = resultSet.getString("description_product");
                Category categoryName = categoryService.findCategoryNameByID(categoryID);
                Product product = new Product(productID, productName, productPrice, productAmout, descriptionProduct,categoryName);
                productList.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    public boolean editCustomer(Product product) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        String query="UPDATE `product`.`product` SET `name_product` =?,price_product=?,amout_product=?,description_product=?,id_categroy=? WHERE (`id_product` =?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2,product.getProductPrice());
            preparedStatement.setString(3, product.getProductAmount());
            preparedStatement.setString(4, product.getProductDescription());
            preparedStatement.setInt(5, product.getCategoryName().getCategoryID());
            preparedStatement.setInt(6,product.getProductId());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean deleteCustomer(String id) {
        Connection connection = baseRepository.connectDatabase();
        String query="delete  from product where id_product =?;";
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public List<Product> searchCustomerByName(String name) {
        Connection connection = baseRepository.connectDatabase();
        List<Product> productList = new ArrayList<>();
        String query="delete  from product where id_product =?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID =Integer.parseInt( resultSet.getString("id_product"));
                int categoryID = resultSet.getInt("id_categroy");
                String productName = resultSet.getString("name_product");
                String productPrice = resultSet.getString("price_product");
                String productAmout = resultSet.getString("amout_product");
                String descriptionProduct = resultSet.getString("description_product");
                Category categoryName = categoryService.findCategoryNameByID(categoryID);
                Product product = new Product(productID, productName, productPrice, productAmout, descriptionProduct,categoryName);
                productList.add(product);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    public boolean createCustomer(Product product) {
        Connection connection = baseRepository.connectDatabase();
        List<Product> customerList = new ArrayList<>();
        String query ="INSERT INTO `product`.`product` (`id_product`, `name_product`, `price_product`, `amout_product`, `color_product`, `description_product`, `id_category`) VALUES (?,?,?,?,?,?);";
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3,product.getProductPrice());
            preparedStatement.setString(4, product.getProductAmount());
            preparedStatement.setString(5, product.getProductDescription());
            preparedStatement.setInt(6, product.getCategoryName().getCategoryID());

            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }
}
