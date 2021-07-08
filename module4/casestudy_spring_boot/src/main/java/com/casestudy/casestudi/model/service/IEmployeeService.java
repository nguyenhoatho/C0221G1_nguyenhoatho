package com.casestudy.casestudi.model.service;


import com.casestudy.casestudi.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findEmployeeByName(String name, Pageable pageable);
    List<Employee> findEmployeeByAll();
    Optional<Employee> findEmployeeById(Integer id);
    void save(Employee employee);
    void remove(Integer id);
}
