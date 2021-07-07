package com.casestudy.casestudi.model.service.customer;



import com.casestudy.casestudi.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
