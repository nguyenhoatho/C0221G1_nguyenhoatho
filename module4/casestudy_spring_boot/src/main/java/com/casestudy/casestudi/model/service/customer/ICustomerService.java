package com.casestudy.casestudi.model.service.customer;

import com.casestudy.casestudi.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Page<Customer> findAllByNameBlogContaining(String searchName,Pageable pageable);
    Customer findById(Integer id);
    void remove(Customer customer);
    void save(Customer customer);
    void edit(Customer customer);

}
