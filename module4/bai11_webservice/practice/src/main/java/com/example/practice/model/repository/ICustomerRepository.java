package com.example.practice.model.repository;

import com.example.practice.model.entity.Customer;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
