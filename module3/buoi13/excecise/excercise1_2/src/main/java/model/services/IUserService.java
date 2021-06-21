package model.services;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    void insertUser(User user) throws SQLException;

   User selectUser(int id);

    List<User> selectAllUser();

    void deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> searchByCountry(String search);

    List<User> sortByName();
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;
    List<User> displayUser();

}