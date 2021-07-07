package com.casestudy.casestudi.model.repository.contract;


import com.casestudy.casestudi.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
//    @Query(value = "select * from contract where contract_id = ?1 and flag = 1",nativeQuery = true)
//    Page<Contract> findAllContract(String name, Pageable pageable);
}
