package model.service.customer_type;

import model.bean.CustomerType;
import model.bean.Employee;

import java.util.List;

public interface ICustomerType {
    public CustomerType findCustomerTypeByID(int id);
    public List<CustomerType> getAllCustomerType();
}
