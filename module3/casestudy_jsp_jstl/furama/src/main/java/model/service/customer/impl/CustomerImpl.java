package model.service.customer.impl;

import model.bean.Customer;
import model.repository.customer.CustomerRepo;
import model.service.customer.ICustomer;

import java.util.List;

public class CustomerImpl implements ICustomer {
    CustomerRepo customerRepository = new CustomerRepo();

    @Override
    public boolean createCustomer(Customer customer) {

        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer findCustomerByID(int id) {
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
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);

    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return customerRepository.searchCustomerByName(name);
    }
}
