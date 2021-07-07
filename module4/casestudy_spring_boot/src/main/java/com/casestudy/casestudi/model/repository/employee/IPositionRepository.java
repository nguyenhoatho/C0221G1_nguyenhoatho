package com.casestudy.casestudi.model.repository.employee;


import com.casestudy.casestudi.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
