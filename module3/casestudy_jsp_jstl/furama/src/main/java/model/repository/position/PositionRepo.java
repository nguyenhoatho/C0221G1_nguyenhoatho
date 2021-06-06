package model.repository.position;

import model.bean.CustomerType;
import model.bean.Position;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepo {
    BaseRepository baseRepository = new BaseRepository();
    final String FIND_POSITION_BY_ID="select *from `position` where position_id=?;";
    final String GET_ALL_POSITION ="select *from `position` ;";

    public Position findPositionByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        Position position = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_POSITION_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                position = new Position(positionId,positionName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }
    public List<Position> getAllPosition() {
        Connection connection = baseRepository.connectDatabase();
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                Position position = new Position(positionId,positionName);
                positionList.add(position);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }
}
