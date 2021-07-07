package com.casestudy.casestudi.model.service.service.Impl;


import com.casestudy.casestudi.model.entity.service.ServiceType;
import com.casestudy.casestudi.model.repository.service.IServiceTypeRepository;
import com.casestudy.casestudi.model.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
