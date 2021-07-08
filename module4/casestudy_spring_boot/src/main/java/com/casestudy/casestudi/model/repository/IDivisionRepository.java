package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.Division;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends PagingAndSortingRepository<Division,Integer> {
}
