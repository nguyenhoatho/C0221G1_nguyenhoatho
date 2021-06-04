package model.repository.services;

import model.bean.Services;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicesRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String CREATE_VILLA ="insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)\n" +
            "values(?,?,?,?,?,?,?,?,?,?);";
    final String CREATE_HOUSE="insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,number_of_floors)\n" +
            "values(?,?,?,?,?,?,?,?,?);";
    final String CREATE_ROOM ="insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id)\n" +
            "values(?,?,?,?,?,?);";

    public boolean createVillaService(Services services) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_VILLA);
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setInt(2, services.getServiceArea());
            preparedStatement.setDouble(3, services.getServiceCost());
            preparedStatement.setInt(4, services.getServiceMaxPeople());
            preparedStatement.setInt(5, services.getRentTypeID());
            preparedStatement.setInt(6, services.getServiceTypeID());
            preparedStatement.setString(7, services.getStandardRoom());
            preparedStatement.setString(8, services.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, services.getPoolArea());
            preparedStatement.setInt(10, services.getNumberOfFloors());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean createHouseService(Services services) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_HOUSE);
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setInt(2, services.getServiceArea());
            preparedStatement.setDouble(3, services.getServiceCost());
            preparedStatement.setInt(4, services.getServiceMaxPeople());
            preparedStatement.setInt(5, services.getRentTypeID());
            preparedStatement.setInt(6, services.getServiceTypeID());
            preparedStatement.setString(7, services.getStandardRoom());
            preparedStatement.setString(8, services.getDescriptionOtherConvenience());
            preparedStatement.setInt(9, services.getNumberOfFloors());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean createHomeService(Services services) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ROOM);
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setInt(2, services.getServiceArea());
            preparedStatement.setDouble(3, services.getServiceCost());
            preparedStatement.setInt(4, services.getServiceMaxPeople());
            preparedStatement.setInt(5, services.getRentTypeID());
            preparedStatement.setInt(6, services.getServiceTypeID());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
