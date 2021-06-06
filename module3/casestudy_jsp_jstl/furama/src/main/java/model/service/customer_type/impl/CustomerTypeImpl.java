package model.service.customer_type.impl;

import model.bean.CustomerType;
import model.repository.customer_type.CustomerTypeRepo;
import model.service.customer_type.ICustomerType;

import java.util.List;

public class CustomerTypeImpl implements ICustomerType {
    CustomerTypeRepo customerTypeRepository = new CustomerTypeRepo();
    @Override
    public CustomerType findCustomerTypeByID(int id) {
        return customerTypeRepository.findCustomerTypeByID(id);
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.getAllCustomerType();
    }
}
