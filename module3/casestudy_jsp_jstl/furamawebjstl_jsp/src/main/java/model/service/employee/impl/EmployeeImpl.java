package model.service.employee.impl;

import model.bean.Employee;
import model.repository.employee.EmployeeRepository;
import model.service.employee.IEmployee;

import java.util.List;

public class EmployeeImpl implements IEmployee {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public boolean createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    @Override
    public Employee findEmployeeByID(int id) {
        return employeeRepository.findEmployeeByID(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return employeeRepository.editEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return employeeRepository.searchEmployeeByName(name);
    }
}
