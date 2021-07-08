package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends PagingAndSortingRepository<ServiceType,Integer> {
}
