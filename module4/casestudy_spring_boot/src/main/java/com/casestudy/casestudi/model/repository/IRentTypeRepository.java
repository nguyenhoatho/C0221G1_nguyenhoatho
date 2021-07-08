package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.RentType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends PagingAndSortingRepository<RentType,Integer> {
}
