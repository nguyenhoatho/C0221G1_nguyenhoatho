package model.service.service_type;

import model.bean.ServiceType;

import java.util.List;

public interface IServiceType {

    public ServiceType findServiceTypeByID(int id);
    public List<ServiceType> getAllServiceType();
}
