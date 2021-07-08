package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.Contract;
import com.casestudy.casestudi.model.repository.IContractRepository;
import com.casestudy.casestudi.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository iContractRepository;
    @Override
    public Page<Contract> findContractByAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAllContract() {
        return (List<Contract>) iContractRepository.findAll();
    }

    @Override
    public Optional<Contract> findContractById(Integer id) {
        return iContractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }
}
