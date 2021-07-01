package com.example.telephone.model.repository;

import com.example.telephone.model.entity.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone, Long> {
}
