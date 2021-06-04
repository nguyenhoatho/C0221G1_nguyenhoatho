package model.service.customer;

import model.bean.Customer;

import java.util.List;

public interface ICustomer {
    public boolean createCustomer(Customer customer);
    public Customer findCustomerByID(int id);
    public List<Customer> getAllCustomer();
    public boolean editCustomer(Customer customer);
    public boolean deleteCustomer(int id);
    public List<Customer> searchCustomerByName(String name);
}
