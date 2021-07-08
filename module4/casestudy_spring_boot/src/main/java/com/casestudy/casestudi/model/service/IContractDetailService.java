package com.casestudy.casestudi.model.service;


import com.casestudy.casestudi.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractDetailService {
    Page<ContractDetail> findContractDetailByAll(Pageable pageable);
    Optional<ContractDetail> findContractDetailById(Integer id);
    void save(ContractDetail contractDetail);
}
