package model.service.impl;

import model.bean.AttachService;
import model.bean.CustomerUsingService;
import model.repository.customer_using_service.CustomerUsingServiceRepository;
import model.service.ICustomerUsingService;

import java.util.List;

public class CustomerUsingServiceImpl implements ICustomerUsingService {
    CustomerUsingServiceRepository customerUsingServiceRepository = new CustomerUsingServiceRepository();
    @Override
    public List<CustomerUsingService> getAllCustomerUsingService() {
        return customerUsingServiceRepository.getAllCustomerUsingService();
    }

    @Override
    public List<CustomerUsingService> getAllAttachServiceUsing() {
        return customerUsingServiceRepository.getAllAttachServiceUsing();
    }

    @Override
    public List<CustomerUsingService> searchCustomerUsingServiceByName(String name) {
        return customerUsingServiceRepository.searchCustomerUsingServiceByName(name);
    }

}
