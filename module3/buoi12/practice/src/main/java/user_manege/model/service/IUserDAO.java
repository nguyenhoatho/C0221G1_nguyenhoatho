package user_manege.model.service;

import user_manege.model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;
    public User userSelect(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id)throws SQLException;
    public boolean updateUser(User user) throws SQLException;

}
