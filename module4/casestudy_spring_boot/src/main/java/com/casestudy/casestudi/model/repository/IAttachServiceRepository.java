package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.Attach_Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends PagingAndSortingRepository<Attach_Service,Integer> {
}
