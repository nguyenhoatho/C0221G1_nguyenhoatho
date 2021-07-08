package com.casestudy.casestudi.model.service;

import com.casestudy.casestudi.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    Page<Service> findServiceByName(String name, Pageable pageable);
    List<Service> findServiceByAll();
    Optional<Service> findServiceById(String id);
    void save(Service service);
}
