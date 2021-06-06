package model.service.attach_service.impl;

import model.bean.AttachService;
import model.repository.attach_service.AttachServiceRepo;
import model.service.attach_service.IAttachService;

import java.util.List;

public class AttachServiceImpl implements IAttachService {
    AttachServiceRepo attachServiceRepository = new AttachServiceRepo();
    @Override
    public AttachService findAttachServiceByID(int id) {
        return attachServiceRepository.findAttachServiceByID(id);
    }

    @Override
    public List<AttachService> getAllAttachService() {
        return attachServiceRepository.getAllAttachService();
    }
}
