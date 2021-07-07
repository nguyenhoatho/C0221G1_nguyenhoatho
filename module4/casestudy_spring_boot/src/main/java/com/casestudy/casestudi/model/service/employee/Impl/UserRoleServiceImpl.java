package com.casestudy.casestudi.model.service.employee.Impl;


import com.casestudy.casestudi.model.entity.employee.AppUser;
import com.casestudy.casestudi.model.entity.employee.UserRole;
import com.casestudy.casestudi.model.repository.employee.IAppRoleRepository;
import com.casestudy.casestudi.model.repository.employee.IRoleUserRepository;
import com.casestudy.casestudi.model.service.employee.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    IRoleUserRepository userRoleRepository;
    @Autowired
    IAppRoleRepository appRoleRepository;
    @Override
    public void save(AppUser appUser, Long id) {
        this.userRoleRepository.save(new UserRole(appUser,this.appRoleRepository.findById(id).orElse(null)));
    }
}
