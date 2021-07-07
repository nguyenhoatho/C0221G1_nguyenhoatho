package com.casestudy.casestudi.model.service.employee;


import com.casestudy.casestudi.model.entity.customer.Customer;
import com.casestudy.casestudi.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable, String name);
    void save(Employee employee);
    void delete(Employee employee);
    Employee findById(int id);
    void edit(Employee employee);
    List<Employee> listEmployee();
}
