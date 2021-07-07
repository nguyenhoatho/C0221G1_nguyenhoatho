package com.casestudy.casestudi.model.repository.service;


import com.casestudy.casestudi.model.entity.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
