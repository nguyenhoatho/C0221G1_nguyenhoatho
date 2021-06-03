package model.repository;

import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    BaseRepository baseRepository=new BaseRepository();
    private static final String  CUSTOMER_SELECT_ALL="select  *from customer";
    private static final String INSERT_CUSTOMER = "INSERT INTO `furama_jstl_jsp`.`customer` " +
            "(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`)" +
            " VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_CUSTOMER ="delete from customer where customer_id = ?";
    private  static final  String   SELECT_CUSTOMER_ID="select * from customer where customer_id = ?";
    private static  final  String UPDATE_CUSTOMER="UPDATE `furama_jstl_jsp`.`customer` SET customer_id = ?, customer_type_id= ?,customer_name= ?,customer.customer_birthday=?,\n" +
            "customer.customer_gender=?,customer.customer_id_card= ?,customer.customer_phone=?,customer.customer_phone=?,customer.customer_email=?,\n" +
            "customer.customer_address=?" +
            "where customer.customer_id= ?;";
    private static final  String SEARCH_CUSTOMER="select * from customer where customer.customer_name=' ? '";


    public CustomerRepo() {
    }
    public void  insertCustomer(Customer customer){

        Connection connection=baseRepository.getConnection();
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement=connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setInt(1,customer.getCustomerId());
            preparedStatement.setInt(2,customer.getCustomerTypeId());
            preparedStatement.setString(3,customer.getCustomerName());
            preparedStatement.setString(4,customer.getCustomerBirthday());
            preparedStatement.setInt(5,customer.getCustomerGender());
            preparedStatement.setString(6,customer.getCustomerIdCard());
            preparedStatement.setString(7,customer.getCustomerPhone());
            preparedStatement.setString(8,customer.getCustomerEmail());
            preparedStatement.setString(9,customer.getCustomerAddress());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public Customer selectCustomerId (int id){
        Connection connection=baseRepository.getConnection();
        PreparedStatement preparedStatement=null;
        Customer customer=null;
        try {
            preparedStatement=connection.prepareStatement(SELECT_CUSTOMER_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerTypeId=resultSet.getInt("customer_type_id");
                String customerName=resultSet.getString("customer_name");
                String customerBirthday=resultSet.getString("customer_birthday");
                int customerGender =resultSet.getInt("customer_gender");
                String customerIdCard=resultSet.getString("customer_id_card");
                String customerPhone =resultSet.getString("customer_phone");
                String customerEmail=resultSet.getString("customer_email");
                String customerAddress=resultSet.getString("customer_address");
                customer=new Customer(id,customerName,customerBirthday,customerGender,
                        customerIdCard,customerPhone,customerEmail,customerTypeId,customerAddress);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
    public boolean deleteCustomer(int id) {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        boolean deleteCustomerCheck = false;
        try {
            preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            deleteCustomerCheck = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return deleteCustomerCheck;
        }
    }
    public boolean updateCustomer(Customer customer){
        Connection connection=baseRepository.getConnection();
        PreparedStatement preparedStatement=null;
        boolean updateCustomer=false;
        try {
            preparedStatement=connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1,customer.getCustomerId());
            preparedStatement.setInt(2,customer.getCustomerTypeId());
            preparedStatement.setString(3,customer.getCustomerName());
            preparedStatement.setString(4,customer.getCustomerBirthday());
            preparedStatement.setInt(5,customer.getCustomerGender());
            preparedStatement.setString(6,customer.getCustomerIdCard());
            preparedStatement.setString(7,customer.getCustomerPhone());
            preparedStatement.setString(8,customer.getCustomerEmail());
            preparedStatement.setString(9,customer.getCustomerAddress());
            System.out.println(preparedStatement.toString());
            updateCustomer=preparedStatement.executeUpdate()>0;

            preparedStatement.close();
            connection.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateCustomer;
    }
    public List<Customer> selectAllCustomer(){
        Connection connection=baseRepository.getConnection();
        PreparedStatement preparedStatement=null;
        List<Customer> customerList=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(CUSTOMER_SELECT_ALL);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId=resultSet.getInt("customer_id");
                int customerTypeId=resultSet.getInt("customer_type_id");
                String customerName=resultSet.getString("customer_name");
                String customerBirthday=resultSet.getString("customer_birthday");
                int customerGender =resultSet.getInt("customer_gender");
                String customerIdCard=resultSet.getString("customer_id_card");
                String customerPhone =resultSet.getString("customer_phone");
                String customerEmail=resultSet.getString("customer_email");
                String customerAddress=resultSet.getString("customer_address");
//                public Customer(int customerId, String customerName, String customerBirthday, int customerGender,
//                String customerIdCard, String customerPhone, String customerEmail, int customerTypeId,
//                String customerAddress)
                customerList.add(new Customer(customerId,customerName,customerBirthday,customerGender,customerIdCard,
                        customerPhone,customerEmail,customerTypeId,customerAddress));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
    public List<Customer> searchCustomerName(String customerName){
        Connection connection=baseRepository.getConnection();
        PreparedStatement preparedStatement=null;
        List<Customer> customerList=new ArrayList<>();
        Customer customer=null;
        try {
            preparedStatement=connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(3,customerName);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId=resultSet.getInt("customer_id");
                int customerTypeId=resultSet.getInt("customer_type_id");
                String customerName1=resultSet.getString("customer_name");
                String customerBirthday=resultSet.getString("customer_birthday");
                int customerGender =resultSet.getInt("customer_gender");
                String customerIdCard=resultSet.getString("customer_id_card");
                String customerPhone =resultSet.getString("customer_phone");
                String customerEmail=resultSet.getString("customer_email");
                String customerAddress=resultSet.getString("customer_address");
//                 public Customer(int customerId, String customerName, String customerBirthday, int customerGender,
//                String customerIdCard, String customerPhone, String customerEmail, int customerTypeId,
//                String customerAddress)
                customerList.add(new Customer(customerId,customerName1,customerBirthday,customerGender,customerIdCard,customerPhone
                        ,customerEmail,customerTypeId,customerAddress));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    }














