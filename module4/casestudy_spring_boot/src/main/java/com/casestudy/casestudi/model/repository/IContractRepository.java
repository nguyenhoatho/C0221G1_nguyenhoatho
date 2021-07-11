package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends PagingAndSortingRepository<Contract,Integer> {

}
