package com.casestudy.casestudi.model.service.service.Impl;


import com.casestudy.casestudi.model.entity.service.Service;
import com.casestudy.casestudi.model.repository.service.IServiceRepository;
import com.casestudy.casestudi.model.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;
    @Override
    public void save(Service service) {
      serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
