package model.repository.employee;

import model.bean.Employee;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String CREATE_EMPLOYEE = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id)\n" +
            "values(?,?,?,?,?,?,?,?,?,?);";
    final String FIND_EMPLOYEE_BY_ID = "select *from employee where employee_id = ?;";
    final String GET_ALL_EMPLOYEE = "select *from employee;";
    final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id =?;";
    final String EDIT_EMPLOYEE_BY_ID = "update employee\n" +
            "set employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?,division_id=?\n" +
            "where employee_id=?;";
    final String SEARCH_EMPLOYEE_BY_NAME = "select *from employee\n" +
                    "where employee_name like ?;";

    public boolean createEmployee(Employee employee) {
        Connection connection = baseRepository.connectDatabase();
        List<Employee> employeeList = new ArrayList<>();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIDCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionID());
            preparedStatement.setInt(9, employee.getEducationDegreeID());
            preparedStatement.setInt(10, employee.getDivisionID());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }


    public Employee findEmployeeByID(int inputID) {
        Connection connection = baseRepository.connectDatabase();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeID = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                Double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionID = resultSet.getInt("position_id");
                int educationDegreeID = resultSet.getInt("education_degree_id");
                int divisionID = resultSet.getInt("division_id");
                employee = new Employee(employeeID, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionID, educationDegreeID, divisionID);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    public List<Employee> getAllEmployee() {
        Connection connection = baseRepository.connectDatabase();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeID = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                Double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionID = resultSet.getInt("position_id");
                int educationDegreeID = resultSet.getInt("education_degree_id");
                int divisionID = resultSet.getInt("division_id");
                Employee employee = new Employee(employeeID, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionID, educationDegreeID, divisionID);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


    public boolean editEmployee(Employee employee) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIDCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionID());
            preparedStatement.setInt(9, employee.getEducationDegreeID());
            preparedStatement.setInt(10, employee.getDivisionID());
            preparedStatement.setInt(11, employee.getEmployeeID());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean deleteEmployee(int id) {
        Connection connection = baseRepository.connectDatabase();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public List<Employee> searchEmployeeByName(String name) {
        Connection connection = baseRepository.connectDatabase();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeID = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                Double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionID = resultSet.getInt("position_id");
                int educationDegreeID = resultSet.getInt("education_degree_id");
                int divisionID = resultSet.getInt("division_id");
                Employee employee = new Employee(employeeID, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionID, educationDegreeID, divisionID);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
