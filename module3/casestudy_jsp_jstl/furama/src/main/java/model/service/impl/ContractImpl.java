package model.service.impl;

import model.bean.Contract;
import model.repository.contract.ContractRepository;
import model.service.IContract;

import java.util.List;

public class ContractImpl implements IContract {
    ContractRepository contractRepository = new ContractRepository();
    @Override
    public boolean createContract(Contract contract) {
        return contractRepository.createContract(contract);
    }

    @Override
    public Contract findContractByID(int id) {
        return contractRepository.findContractByID(id);
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.getAllContract();
    }

    @Override
    public boolean editContractUsing(Contract contract) {
        return contractRepository.editContractUsing(contract);
    }

}
