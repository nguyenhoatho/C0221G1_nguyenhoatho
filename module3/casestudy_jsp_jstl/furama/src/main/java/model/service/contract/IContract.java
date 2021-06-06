package model.service.contract;


import model.bean.Contract;

import java.util.List;

public interface IContract {
    public boolean createContract(Contract contract);
    public Contract findContractByID(int id);
    public List<Contract> getAllContract();
}
