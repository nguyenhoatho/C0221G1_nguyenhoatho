package model.repository.education_degree;

import model.bean.Division;
import model.bean.EducationDegree;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String FIND_EDUCATION_DEGREE_BY_ID="select *from education_degree where education_degree_id=?;";
    final String GET_ALL_EDUCATION_DEGREE ="select *from education_degree ;";

    public EducationDegree findEducationDegreeByID(int id) {
        Connection connection = baseRepository.connectDatabase();
        EducationDegree educationDegree = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EDUCATION_DEGREE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                educationDegree = new EducationDegree(educationDegreeId,educationDegreeName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegree;
    }


    public List<EducationDegree> getAllEducationDegree() {
        Connection connection = baseRepository.connectDatabase();
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(educationDegreeId,educationDegreeName);
                educationDegreeList.add(educationDegree);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;

    }
}
