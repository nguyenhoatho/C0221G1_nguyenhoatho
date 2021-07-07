package com.casestudy.casestudi.model.service.contract.Impl;


import com.casestudy.casestudi.model.entity.contract.ContractDetail;
import com.casestudy.casestudi.model.repository.contract.IContractDetailRepository;
import com.casestudy.casestudi.model.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
