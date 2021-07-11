package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.UserRole;
import com.casestudy.casestudi.model.repository.IUserRoleRepository;
import com.casestudy.casestudi.model.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    IUserRoleRepository iUserRoleRepository;
    @Override
    public void save(UserRole userRole) {
        iUserRoleRepository.save(userRole);
    }
}
