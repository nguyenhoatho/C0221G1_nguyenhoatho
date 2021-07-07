package com.casestudy.casestudi.model.service.contract;


import com.casestudy.casestudi.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
//    Page<Contract> findAll(String name,Pageable pageable);
    void save(Contract contract);
    List<Contract> findAll();
}
