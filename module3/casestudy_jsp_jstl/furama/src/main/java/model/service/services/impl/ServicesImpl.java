package model.service.services.impl;

import model.bean.Services;
import model.repository.services.ServicesRepository;
import model.service.services.IServices;

import java.util.List;

public class ServicesImpl implements IServices {
    ServicesRepository servicesRepository = new ServicesRepository();
    @Override
    public boolean createVillaService(Services services) {
        return servicesRepository.createVillaService(services);
    }

    @Override
    public boolean createHouseService(Services services) {
        return servicesRepository.createHouseService(services);
    }

    @Override
    public boolean createRoomService(Services services) {
        return servicesRepository.createRoomService(services);
    }

    @Override
    public Services findServiceByID(int id) {
        return servicesRepository.findServiceByID(id);
    }

    @Override
    public List<Services> getAllServices() {
        return servicesRepository.getAllServices();
    }
}
