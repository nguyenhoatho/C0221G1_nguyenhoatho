package com.casestudy.casestudi.model.repository;

import com.casestudy.casestudi.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
}
