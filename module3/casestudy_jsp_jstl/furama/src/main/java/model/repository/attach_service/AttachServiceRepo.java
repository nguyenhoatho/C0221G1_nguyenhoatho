package model.repository.attach_service;

import model.bean.AttachService;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepo {
    BaseRepository baseRepository = new BaseRepository();
    final String FIND_ATTACH_SERVICE_BY_ID="select *from attach_service where attach_service_id=?;";
    final String GET_ALL_ATTACH_SERVICE ="select *from attach_service ;";



    public AttachService findAttachServiceByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        AttachService attachService = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ATTACH_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                Double attachServiceCost = resultSet.getDouble("attach_service_cost");
                int attachServiceUnit = resultSet.getInt("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");
                attachService = new AttachService(attachServiceId,attachServiceName,attachServiceCost,attachServiceUnit,attachServiceStatus);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachService;

    }

    public List<AttachService> getAllAttachService() {
        Connection connection = baseRepository.connectDatabase();
        List<AttachService> attachServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ATTACH_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                Double attachServiceCost = resultSet.getDouble("attach_service_cost");
                int attachServiceUnit = resultSet.getInt("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");
                AttachService attachService = new AttachService(attachServiceId,attachServiceName,attachServiceCost,attachServiceUnit,attachServiceStatus);
                attachServiceList.add(attachService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServiceList;

    }
}
