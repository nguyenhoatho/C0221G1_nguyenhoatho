package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {

    private String jdbcURL= "jdbc:mysql://localhost:3306/furama_jstl_jsp?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword ="1403";

    protected Connection getConnection(){
        Connection connection =null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
