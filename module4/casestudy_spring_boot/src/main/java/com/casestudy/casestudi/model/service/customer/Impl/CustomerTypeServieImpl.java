package com.casestudy.casestudi.model.service.customer.Impl;


import com.casestudy.casestudi.model.entity.customer.CustomerType;
import com.casestudy.casestudi.model.repository.customer.ICustomerTypeRepository;
import com.casestudy.casestudi.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServieImpl implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
