package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType,Integer> {
}
