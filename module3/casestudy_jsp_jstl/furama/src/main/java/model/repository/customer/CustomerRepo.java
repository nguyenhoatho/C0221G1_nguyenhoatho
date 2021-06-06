package model.repository.customer;

import model.bean.Customer;
import model.bean.CustomerType;
import model.repository.BaseRepository;
import model.service.customer_type.ICustomerType;
import model.service.customer_type.impl.CustomerTypeImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    BaseRepository baseRepository = new BaseRepository();
    ICustomerType iCustomerType = new CustomerTypeImpl();

    final String CREATE_CUSTOMER = "insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)\n" +
            "values(?,?,?,?,?,?,?,?);";
    final String FIND_CUSTOMER_BY_ID = "select *from customer where customer_id = ?;";
    final String GET_ALL_CUSTOMER = "select *from customer;";
    final String EDIT_CUSTOMER = " update customer\n" +
            " set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?\n" +
            " where customer_id =?;";
    final String DELETE_CUSTOMER_BY_ID = "delete  from customer where customer_id =?;";
    final String SEARCH_CUSTOMER_BY_NAME = "select *from customer\n" +
            "where customer_name like ?;";


    public boolean createCustomer(Customer customer) {
        Connection connection = baseRepository.connectDatabase();
        List<Customer> customerList = new ArrayList<>();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeID());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setString(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIDCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }


    public Customer findCustomerByID(int inputID) {
        Connection connection = baseRepository.connectDatabase();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerID = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                CustomerType customerType = iCustomerType.findCustomerTypeByID(customerTypeId);
                customer = new Customer(customerID, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getAllCustomer() {
        Connection connection = baseRepository.connectDatabase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerID = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                CustomerType customerType = iCustomerType.findCustomerTypeByID(customerTypeId);
                Customer customer = new Customer(customerID, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }


    public boolean editCustomer(Customer customer) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeID());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setString(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIDCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerID());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean deleteCustomer(int id) {
        Connection connection = baseRepository.connectDatabase();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public List<Customer> searchCustomerByName(String name) {
        Connection connection = baseRepository.connectDatabase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerID = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                CustomerType customerType = iCustomerType.findCustomerTypeByID(customerTypeId);
                Customer customer = new Customer(customerID, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

}


