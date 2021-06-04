package model.service.services.impl;

import model.bean.Services;
import model.repository.services.ServicesRepository;
import model.service.services.IServices;

public class ServicesImpl implements IServices {
    ServicesRepository servicesRepository = new ServicesRepository();
    @Override
    public boolean createVillaService(Services services) {
        return servicesRepository.createVillaService(services);
    }

    @Override
    public boolean createHouseService(Services services) {
        return servicesRepository.createVillaService(services);
    }

    @Override
    public boolean createHomeService(Services services) {
        return servicesRepository.createVillaService(services);
    }
}
