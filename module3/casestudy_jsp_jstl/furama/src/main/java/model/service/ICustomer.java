package model.service;

import model.bean.Customer;

import java.util.List;

public interface ICustomer {
    public boolean createCustomer(Customer customer);
    public Customer findCustomerByID(String id);
    public List<Customer> getAllCustomer();
    public boolean editCustomer(Customer customer);
    public boolean deleteCustomer(String id);
    public List<Customer> searchCustomerByName(String name);
}
