package com.casestudy.casestudi.model.service.impl;

import com.casestudy.casestudi.model.entity.ServiceType;
import com.casestudy.casestudi.model.repository.IServiceTypeRepository;
import com.casestudy.casestudi.model.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository iServiceTypeRepository;
    @Override
    public List<ServiceType> findServiceTypeByAll() {
        return (List<ServiceType>) iServiceTypeRepository.findAll();
    }
}
