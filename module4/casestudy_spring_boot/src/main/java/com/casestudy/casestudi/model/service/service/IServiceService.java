package com.casestudy.casestudi.model.service.service;



import com.casestudy.casestudi.model.entity.service.Service;

import java.util.List;

public interface IServiceService {
    void save(Service service);
    List<Service> findAll();
}
