package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.Employee;
import com.casestudy.casestudi.model.repository.IEmployeeRepository;
import com.casestudy.casestudi.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public Page<Employee> findEmployeeByName(String name, Pageable pageable) {
        return iEmployeeRepository.findEmployeeByEmployeeNameContainingAndEmployeeFlagTrue(name,pageable);
    }

    @Override
    public List<Employee> findEmployeeByAll() {
        return (List<Employee>) iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        iEmployeeRepository.deleteById(id);
    }
}
