package model.service.impl;

import model.bean.Customer;
import model.repository.customer.CustomerRepository;
import model.service.ICustomer;

import java.util.List;

public class CustomerImpl implements ICustomer {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public boolean createCustomer(Customer customer) {

        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer findCustomerByID(String id) {
        return customerRepository.findCustomerByID(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return customerRepository.editCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerRepository.deleteCustomer(id);

    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return customerRepository.searchCustomerByName(name);
    }
}
