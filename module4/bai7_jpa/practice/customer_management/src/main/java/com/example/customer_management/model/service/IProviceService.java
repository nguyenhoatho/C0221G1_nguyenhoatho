package com.example.customer_management.model.service;

import com.example.customer_management.model.entity.customer.Customer;
import com.example.customer_management.model.entity.province.Province;

import java.util.Optional;

public interface IProviceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
