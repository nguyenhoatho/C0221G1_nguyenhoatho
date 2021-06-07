package model.repository.rent_type;

import model.bean.RentType;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository {
    BaseRepository baseRepository = new BaseRepository();

    final String FIND_RENT_TYPE_BY_ID="select *from rent_type where rent_type_id=?;";
    final String GET_ALL_RENT_TYPE ="select *from rent_type ;";
    public List<RentType> getAllRentType() {
        Connection connection = baseRepository.connectDatabase();
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                Double rentTypeCost = resultSet.getDouble("rent_type_cost");
                RentType rentType = new RentType(rentTypeId,rentTypeName,rentTypeCost);
                rentTypeList.add(rentType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }

    public RentType findRentTypeByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        RentType rentType = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_RENT_TYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                Double rentTypeCost = resultSet.getDouble("rent_type_cost");
                rentType = new RentType(rentTypeId,rentTypeName,rentTypeCost);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentType;
    }



}
