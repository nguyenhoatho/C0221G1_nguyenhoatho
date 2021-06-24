package com.example.customerpageable.model.service;

import com.example.customerpageable.model.entity.customer.Customer;
import com.example.customerpageable.model.entity.province.Province;

import java.util.Optional;

public interface IProviceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
