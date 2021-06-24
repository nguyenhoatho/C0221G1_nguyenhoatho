package com.example.customer_management.model.service;

import com.example.customer_management.model.entity.customer.Customer;
import com.example.customer_management.model.entity.province.Province;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
