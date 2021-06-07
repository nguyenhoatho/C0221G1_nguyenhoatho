package model.repository.contract_detail;

import model.bean.ContractDetail;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String CREATE_CONTRACT_DETAIL = "insert into contract_detail(contract_id,attach_service_id,quantity)\n" +
            "values(?,?,?);";


    public boolean createContractDetail(ContractDetail contractDetail) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContract().getContractID());
            preparedStatement.setString(2, contractDetail.getAttachServiceID());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
