package com.example.customer_management.model.repository;

import com.example.customer_management.model.entity.customer.Customer;
import com.example.customer_management.model.entity.province.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
