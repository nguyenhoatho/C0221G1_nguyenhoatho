package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.RentType;
import com.casestudy.casestudi.model.repository.IRentTypeRepository;
import com.casestudy.casestudi.model.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findRentTypeByAll() {
        return (List<RentType>) iRentTypeRepository.findAll();
    }
}
