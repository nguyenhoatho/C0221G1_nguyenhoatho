package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customer> selectAll();
    boolean deleteCustomer(int id) throws  SQLException;
    boolean updateCustomer (Customer customer) throws SQLException;
    List<Customer> searchCustomer(String customerName);
    void insertCustomer(Customer customer) throws SQLException;
    Customer selectCustomer(int id);




}
