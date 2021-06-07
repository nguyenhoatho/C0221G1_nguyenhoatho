package model.repository.customer_using_service;

import model.bean.AttachService;
import model.bean.Customer;
import model.bean.CustomerType;
import model.bean.CustomerUsingService;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String GET_ALL_CUSTOMER_USING_SERVICE ="select *from customer_using_service;";
    final String GET_ALL_ATTACH_SERVICE_USING ="select *from attach_service_using;";
    final String FIND_CUSTOMER_USING_SERVICE ="select *from customer_using_service\n" +
            "where customer_name like ? ;";



    public List<CustomerUsingService> getAllAttachServiceUsing() {
        Connection connection = baseRepository.connectDatabase();
        List<CustomerUsingService> customerUsingServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ATTACH_SERVICE_USING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contract_id = resultSet.getInt("contract_id");
                String attachServiceId = resultSet.getString("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                int quantity = resultSet.getInt("quantity");
                CustomerUsingService customerUsingService = new CustomerUsingService(contract_id,attachServiceId,attachServiceName,quantity);
                customerUsingServiceList.add(customerUsingService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUsingServiceList;
    }
    public List<CustomerUsingService> searchCustomerUsingServiceByName(String name) {
        Connection connection = baseRepository.connectDatabase();
        List<CustomerUsingService> customerUsingServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_USING_SERVICE);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerId = resultSet.getString("customer_id");
                String customerName = resultSet.getString("customer_name");
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                String attach_service_id = resultSet.getString("attach_service_id");
                String serviceName = resultSet.getString("service_name");
                String attachServiceName = resultSet.getString("attach_service_name");
                int quantity = resultSet.getInt("quantity");
                CustomerUsingService customerUsingService = new CustomerUsingService(customerId,customerName,contractId,contractStartDate,contractEndDate,serviceName,attach_service_id,attachServiceName,quantity);
                customerUsingServiceList.add(customerUsingService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUsingServiceList;
    }
    public List<CustomerUsingService> getAllCustomerUsingService() {
        Connection connection = baseRepository.connectDatabase();
        List<CustomerUsingService> customerUsingServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER_USING_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerId = resultSet.getString("customer_id");
                String customerName = resultSet.getString("customer_name");
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                String attach_service_id = resultSet.getString("attach_service_id");
                String serviceName = resultSet.getString("service_name");
                String attachServiceName = resultSet.getString("attach_service_name");
                int quantity = resultSet.getInt("quantity");
                CustomerUsingService customerUsingService = new CustomerUsingService(customerId,customerName,contractId,contractStartDate,contractEndDate,serviceName,attach_service_id,attachServiceName,quantity);
                customerUsingServiceList.add(customerUsingService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUsingServiceList;
    }
}
