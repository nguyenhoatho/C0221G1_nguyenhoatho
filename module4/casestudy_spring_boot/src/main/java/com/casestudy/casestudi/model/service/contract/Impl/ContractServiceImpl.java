package com.casestudy.casestudi.model.service.contract.Impl;


import com.casestudy.casestudi.model.entity.contract.Contract;
import com.casestudy.casestudi.model.repository.contract.IContractRepository;
import com.casestudy.casestudi.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository contractRepository;


    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
