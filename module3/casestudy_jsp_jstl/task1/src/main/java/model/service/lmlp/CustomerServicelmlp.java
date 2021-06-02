package model.service.lmlp;

import model.bean.Customer;
import model.repository.CustomerRepo;
import model.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServicelmlp implements CustomerService {
    CustomerRepo customerRepo= new CustomerRepo();
    @Override
    public List<Customer> selectAll() {

        return customerRepo.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepo.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepo.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchCustomer(String customerName) {
        return customerRepo.searchCustomerName(customerName);
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepo.insertCustomer(customer);

    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepo.selectCustomerId(id);
    }
}
