package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends PagingAndSortingRepository<Service,String>{
    Page<Service> findServiceByServiceNameContaining(String search, Pageable pageable);
}
