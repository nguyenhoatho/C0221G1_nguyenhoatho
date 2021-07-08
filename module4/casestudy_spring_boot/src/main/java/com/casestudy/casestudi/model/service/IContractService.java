package com.casestudy.casestudi.model.service;



import com.casestudy.casestudi.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    Page<Contract> findContractByAll(Pageable pageable);
    List<Contract> findAllContract();
    Optional<Contract> findContractById(Integer id);
    void save(Contract contract);
}
