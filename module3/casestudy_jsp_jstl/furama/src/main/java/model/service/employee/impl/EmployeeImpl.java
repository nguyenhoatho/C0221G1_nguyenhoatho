package model.service.employee.impl;

import model.bean.Employee;
import model.repository.employee.EmployeeRepo;
import model.service.employee.IEmployee;

import java.util.List;

public class EmployeeImpl implements IEmployee {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    @Override
    public boolean createEmployee(Employee employee) {
        return employeeRepo.createEmployee(employee);
    }

    @Override
    public Employee findEmployeeByID(int id) {
        return employeeRepo.findEmployeeByID(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.getAllEmployee();
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return employeeRepo.editEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepo.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return employeeRepo.searchEmployeeByName(name);
    }
}
