package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.EducationDegree;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends PagingAndSortingRepository<EducationDegree,Integer> {
}
