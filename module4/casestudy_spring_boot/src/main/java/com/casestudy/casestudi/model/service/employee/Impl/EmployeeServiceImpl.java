package com.casestudy.casestudi.model.service.employee.Impl;

import com.casestudy.casestudi.model.entity.customer.Customer;
import com.casestudy.casestudi.model.entity.employee.Employee;
import com.casestudy.casestudi.model.repository.employee.IEmployeeRepository;
import com.casestudy.casestudi.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable, String name) {
        return employeeRepository.findAllByEmployee(name,pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employee.setFlag(0);
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAllList();
    }
}
