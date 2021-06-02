package model.services.Impl;

import model.bean.User;
import model.repository.UserRepository;
import model.services.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    UserRepository reponsitory = new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        reponsitory.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return reponsitory.selectUser(id);
    }

    @Override
    public List<User> selectAllUser() {
        return reponsitory.selectAllUser();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        reponsitory.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
//        return reponsitory.updateUserFalse(user);
        return reponsitory.updateUsers(user);
    }

    @Override
    public List<User> searchByCountry(String search) {
        return reponsitory.searchByCountry(search);
    }

    @Override
    public List<User> sortByName() {
        return reponsitory.sortByName();
    }

    @Override
    public User getUserById(int id) {
        return reponsitory.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        reponsitory.insertUserStore(user);
    }

    @Override
    public List<User> displayUser() {
        return reponsitory.getUser();
    }

}
