package model.service.attach_service;


import model.bean.AttachService;

import java.util.List;

public interface IAttachService {
    public AttachService findAttachServiceByID(int id);
    public List<AttachService> getAllAttachService();
}
