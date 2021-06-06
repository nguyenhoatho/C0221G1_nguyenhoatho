package model.repository.contract;

import model.bean.*;
import model.repository.BaseRepository;
import model.service.attach_service.IAttachService;
import model.service.customer.ICustomer;
import model.service.customer.impl.CustomerImpl;
import model.service.employee.IEmployee;
import model.service.employee.impl.EmployeeImpl;
import model.service.services.IServices;
import model.service.services.impl.ServicesImpl;

import javax.xml.ws.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepo {
    BaseRepository baseRepository = new BaseRepository();
    IEmployee iEmployee = new EmployeeImpl();
    ICustomer iCustomer = new CustomerImpl();
    IServices iServices = new ServicesImpl();

    final String CREATE_CONTRACT = "insert into contract(contract_start_date,contract_end_date,contract_deposit,employee_id,customer_id,service_id)\n" +
            "values(?,?,?,?,?,?);";
    final String FIND_CONTRACT_BY_ID = "select *from contract where contract_id=?;";
    final String GET_ALL_CONTRACT = "select *from contract ;";

    public boolean createContract(Contract contract) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CONTRACT);
            preparedStatement.setString(1, contract.getContractStartDate());
            preparedStatement.setString(2, contract.getContractEndDate());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setInt(4, contract.getEmployee().getEmployeeID());
            preparedStatement.setInt(5, contract.getCustomer().getCustomerID());
            preparedStatement.setInt(6, contract.getServices().getServiceID());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public Contract findContractByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CONTRACT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int serviceId = resultSet.getInt("service_id");

                Employee employee = iEmployee.findEmployeeByID(employeeId);
                Customer customer = iCustomer.findCustomerByID(customerId);
                Services services = iServices.findServiceByID(serviceId);

                contract = new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, employee, customer, services);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }


    public List<Contract> getAllContract() {
        Connection connection = baseRepository.connectDatabase();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                Double contractDeposit = resultSet.getDouble("contract_deposit");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int serviceId = resultSet.getInt("service_id");

                Employee employee = iEmployee.findEmployeeByID(employeeId);
                Customer customer = iCustomer.findCustomerByID(customerId);
                Services services = iServices.findServiceByID(serviceId);

                Contract contract = new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, employee, customer, services);

                contractList.add(contract);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}
