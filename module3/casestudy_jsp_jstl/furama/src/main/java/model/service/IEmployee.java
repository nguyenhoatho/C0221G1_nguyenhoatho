package model.service;

import model.bean.Employee;

import java.util.List;

public interface IEmployee {
    public boolean createEmployee(Employee employee);
    public Employee findEmployeeByID(int id);
    public List<Employee> getAllEmployee();
    public boolean editEmployee(Employee employee);
    public boolean deleteEmployee(int id);
    public List<Employee> searchEmployeeByName(String name);
}
