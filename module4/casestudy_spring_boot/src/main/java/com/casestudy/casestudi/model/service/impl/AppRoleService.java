package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.AppRole;
import com.casestudy.casestudi.model.repository.IAppRoleRepository;
import com.casestudy.casestudi.model.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    IAppRoleRepository iAppRoleRepository;
    @Override
    public AppRole findByIdAppRole(Long id) {
        return iAppRoleRepository.findById(id).orElse(null);
    }
}
