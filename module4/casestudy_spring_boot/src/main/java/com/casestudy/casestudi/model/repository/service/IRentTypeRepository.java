package com.casestudy.casestudi.model.repository.service;


import com.casestudy.casestudi.model.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
