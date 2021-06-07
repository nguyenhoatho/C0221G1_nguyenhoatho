package model.service.impl;

import model.bean.AttachService;
import model.repository.attach_service.AttachServiceRepository;
import model.service.IAttachService;

import java.util.List;

public class AttachServiceImpl implements IAttachService {
    AttachServiceRepository attachServiceRepository = new AttachServiceRepository();
    @Override
    public AttachService findAttachServiceByID(int id) {
        return attachServiceRepository.findAttachServiceByID(id);
    }

    @Override
    public List<AttachService> getAllAttachService() {
        return attachServiceRepository.getAllAttachService();
    }
}
