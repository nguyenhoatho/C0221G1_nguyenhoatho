package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.ContractDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail,Integer> {
}
