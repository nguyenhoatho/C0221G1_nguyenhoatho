package model.repository.customer_type;

import model.bean.Customer;
import model.bean.CustomerType;
import model.bean.Employee;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepo {
    BaseRepository baseRepository= new BaseRepository();
    final String FIND_CUSTOMER_TYPE_BY_ID="select *from customer_type where customer_type_id=?;";
    final String GET_ALL_CUSTOMER_TYPE ="select *from customer_type ;";

    public CustomerType findCustomerTypeByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        CustomerType customerType = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_TYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                 customerType = new CustomerType(customerTypeId,customerTypeName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerType;
    }

    public List<CustomerType> getAllCustomerType() {
        Connection connection = baseRepository.connectDatabase();
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customerTypeId,customerTypeName);
                customerTypeList.add(customerType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;

    }
}
