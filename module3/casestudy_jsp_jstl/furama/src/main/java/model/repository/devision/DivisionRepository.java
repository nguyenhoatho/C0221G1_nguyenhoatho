package model.repository.devision;

import model.bean.Division;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String FIND_BY_ID ="select *from division where division_id=?;";
    final String SELECT_ALL_DIVISION ="select *from division ;";

    public Division findDivisionByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        Division division = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                division = new Division(divisionId,divisionName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }


    public List<Division> getAllDivision() {
        Connection connection = baseRepository.connectDatabase();
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                Division division = new Division(divisionId,divisionName);
                divisionList.add(division);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;

    }
}
