package com.casestudy.casestudi.model.service.customer.Impl;


import com.casestudy.casestudi.model.entity.customer.Customer;
import com.casestudy.casestudi.model.repository.customer.ICustomerRepository;
import com.casestudy.casestudi.model.repository.customer.ICustomerTypeRepository;
import com.casestudy.casestudi.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllCustomerList();
    }

    @Override
    public Page<Customer> findAllByNameBlogContaining(String searchName, Pageable pageable) {
        return customerRepository.findAllByNameBlogContaining(searchName,pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Customer customer) {
        customer.setFlag(0);
        customerRepository.save(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.save(customer);
    }
}
