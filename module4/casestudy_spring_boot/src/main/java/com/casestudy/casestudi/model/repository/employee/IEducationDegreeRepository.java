package com.casestudy.casestudi.model.repository.employee;


import com.casestudy.casestudi.model.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
