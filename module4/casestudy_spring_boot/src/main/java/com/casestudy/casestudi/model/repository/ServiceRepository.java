package com.casestudy.casestudi.model.repository;

import com.casestudy.casestudi.model.entity.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service,Integer> {
}
