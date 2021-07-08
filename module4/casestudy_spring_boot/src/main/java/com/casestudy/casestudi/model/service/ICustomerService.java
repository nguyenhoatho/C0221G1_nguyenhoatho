package com.casestudy.casestudi.model.service;


import com.casestudy.casestudi.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findCustomerByName(String name, Pageable pageable);
    List<Customer>findCustomerByAll();
    Optional<Customer> findCustomerById(String id);
    void save(Customer customer);
    void remove(String id);
}
