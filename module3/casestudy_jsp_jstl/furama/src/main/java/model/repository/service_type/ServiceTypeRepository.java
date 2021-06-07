package model.repository.service_type;

import model.bean.RentType;
import model.bean.ServiceType;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository {
    BaseRepository baseRepository = new BaseRepository();

    final String FIND_SERVICE_TYPE_BY_ID="select *from service_type where service_type_id=?;";
    final String GET_ALL_SERVICE_TYPE ="select *from service_type ;";

    public ServiceType findServiceTypeByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        ServiceType serviceType = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SERVICE_TYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceType = new ServiceType(serviceTypeId,serviceTypeName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceType;
    }


    public List<ServiceType> getAllServiceType() {
        Connection connection = baseRepository.connectDatabase();
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                ServiceType serviceType = new ServiceType(serviceTypeId,serviceTypeName);
                serviceTypeList.add(serviceType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
