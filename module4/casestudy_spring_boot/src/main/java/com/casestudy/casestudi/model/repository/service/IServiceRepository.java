package com.casestudy.casestudi.model.repository.service;


import com.casestudy.casestudi.model.entity.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
}
