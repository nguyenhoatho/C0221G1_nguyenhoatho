package model.service.impl;

import model.bean.Services;
import model.repository.services.ServicesRepository;
import model.service.IServices;

import java.util.List;

public class ServicesImpl implements IServices {
    ServicesRepository servicesRepository = new ServicesRepository();
    @Override
    public boolean createService(Services services) {
        return servicesRepository.createService(services);
    }

    @Override
    public Services findServiceByID(String id) {
        return servicesRepository.findServiceByID(id);
    }

    @Override
    public List<Services> getAllServices() {
        return servicesRepository.getAllServices();
    }
}
