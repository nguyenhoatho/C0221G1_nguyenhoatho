package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    Page<Employee> findEmployeeByEmployeeNameContainingAndEmployeeFlagTrue(String name, Pageable pageable);
}
