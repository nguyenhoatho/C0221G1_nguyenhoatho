package model.service.impl;

import model.bean.CustomerType;
import model.repository.customer_type.CustomerTypeRepository;
import model.service.ICustomerType;

import java.util.List;

public class CustomerTypeImpl implements ICustomerType {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public CustomerType findCustomerTypeByID(int id) {
        return customerTypeRepository.findCustomerTypeByID(id);
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.getAllCustomerType();
    }
}
