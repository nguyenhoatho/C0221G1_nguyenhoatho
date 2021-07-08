package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.Customer;
import com.casestudy.casestudi.model.repository.ICustomerRepository;
import com.casestudy.casestudi.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> findCustomerByName(String name, Pageable pageable) {
        return iCustomerRepository.findCustomerByCustomerNameContainingAndCustomerFlagTrue(name,pageable);
    }

    @Override
    public List<Customer> findCustomerByAll() {
        return (List<Customer>) iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer>  findCustomerById(String id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(String id) {
        iCustomerRepository.deleteById(id);
    }
}
