package com.casestudy.casestudi.model.service.impl;

import com.casestudy.casestudi.model.entity.CustomerType;
import com.casestudy.casestudi.model.repository.ICustomerTypeRepository;
import com.casestudy.casestudi.model.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findCustomerTypeByAll() {
        return (List<CustomerType>) iCustomerTypeRepository.findAll();
    }
}
