package com.casestudy.casestudi.model.service.employee.Impl;


import com.casestudy.casestudi.model.entity.employee.AppRole;
import com.casestudy.casestudi.model.repository.employee.IAppRoleRepository;
import com.casestudy.casestudi.model.service.employee.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements IAppRoleService {
    @Autowired
    private IAppRoleRepository appRoleRepository;
    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(Long id) {
        return appRoleRepository.findById(id).orElse(null);
    }
}