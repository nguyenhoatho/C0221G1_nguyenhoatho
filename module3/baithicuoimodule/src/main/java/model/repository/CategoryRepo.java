package model.repository;

import model.BaseRepository;
import model.bean.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo {
    BaseRepository baseRepository=new BaseRepository();
    public Category findCategoryNameByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        String query="select *from category  where id_category=?";
        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int categoryID = resultSet.getInt("id_category");
                String categoryName = resultSet.getString("name_category");
                category = new Category(categoryID,categoryName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public List<Category> getAllCategory() {
        Connection connection = baseRepository.connectDatabase();
        String query="select * from category;";
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int categoryID = resultSet.getInt("id_category");
                String categoryName= resultSet.getString("name_category");
                Category category = new Category(categoryID,categoryName);
                categoryList.add(category);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;

    }
}
