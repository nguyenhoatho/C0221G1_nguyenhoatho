package model.service.contract.impl;

import model.bean.Contract;
import model.repository.contract.ContractRepo;
import model.service.contract.IContract;

import java.util.List;

public class ContractImpl implements IContract {
    ContractRepo contractRepo = new ContractRepo();
    @Override
    public boolean createContract(Contract contract) {
        return contractRepo.createContract(contract);
    }

    @Override
    public Contract findContractByID(int id) {
        return contractRepo.findContractByID(id);
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepo.getAllContract();
    }
}
