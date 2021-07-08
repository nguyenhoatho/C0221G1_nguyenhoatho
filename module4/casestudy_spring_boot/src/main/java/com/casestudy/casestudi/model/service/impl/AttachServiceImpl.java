package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.Attach_Service;
import com.casestudy.casestudi.model.repository.IAttachServiceRepository;
import com.casestudy.casestudi.model.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository iAttachServiceRepository;
    @Override
    public List<Attach_Service> findAttachServiceByAll() {
        return (List<Attach_Service>) iAttachServiceRepository.findAll();
    }
}
