package model.repository.services;

import model.bean.RentType;
import model.bean.ServiceType;
import model.bean.Services;
import model.repository.BaseRepository;
import model.service.IRentType;
import model.service.impl.RentTypeImpl;
import model.service.IServiceType;
import model.service.impl.ServiceTypeImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesRepository {
    BaseRepository baseRepository = new BaseRepository();
    IRentType iRentType = new RentTypeImpl();
    IServiceType iServiceType = new ServiceTypeImpl();

    final String CREATE_SERVICE ="insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)\n" +
            "values(?,?,?,?,?,?,?,?,?,?,?);";
    final String FIND_SERVICE_BY_ID = "select *from service where service_id = ?;";
    final String GET_ALL_SERVICES = "select *from service;";


    public boolean createService(Services services) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SERVICE);
            preparedStatement.setString(1, services.getServiceID());
            preparedStatement.setString(2, services.getServiceName());
            preparedStatement.setInt(3, services.getServiceArea());
            preparedStatement.setDouble(4, services.getServiceCost());
            preparedStatement.setInt(5, services.getServiceMaxPeople());
            preparedStatement.setInt(6, services.getRentType().getRentTypeID());
            preparedStatement.setInt(7, services.getServiceType().getServiceTypeID());
            preparedStatement.setString(8, services.getStandardRoom());
            preparedStatement.setString(9, services.getDescriptionOtherConvenience());
            preparedStatement.setString(10, services.getPoolArea());
            preparedStatement.setString(11, services.getNumberOfFloors());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }



    public Services findServiceByID(String id) {
        Connection connection = baseRepository.connectDatabase();
        Services services = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SERVICE_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String serviceId = resultSet.getString("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                Double service_cost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                String poolArea = resultSet.getString("pool_area");
                String numberOfFloors = resultSet.getString("number_of_floors");

                RentType rentType = iRentType.findRentTypeByID(rentTypeId);
                ServiceType serviceType = iServiceType.findServiceTypeByID(serviceTypeId);

                services = new Services(serviceId,serviceName,serviceArea,service_cost,serviceMaxPeople,rentType,serviceType,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
    public List<Services> getAllServices() {
        Connection connection = baseRepository.connectDatabase();
        List<Services> servicesList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SERVICES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String serviceId = resultSet.getString("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                Double service_cost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                String poolArea = resultSet.getString("pool_area");
                String numberOfFloors = resultSet.getString("number_of_floors");

                RentType rentType = iRentType.findRentTypeByID(rentTypeId);
                ServiceType serviceType = iServiceType.findServiceTypeByID(serviceTypeId);

                Services services = new Services(serviceId,serviceName,serviceArea,service_cost,serviceMaxPeople,rentType,serviceType,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors);
                servicesList.add(services);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicesList;
    }

}
