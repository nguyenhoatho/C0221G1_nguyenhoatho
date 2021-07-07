package com.casestudy.casestudi.model.service.employee.Impl;

import com.casestudy.casestudi.model.entity.employee.AppUser;
import com.casestudy.casestudi.model.repository.employee.IAppUserRepository;
import com.casestudy.casestudi.model.service.employee.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Override
    public AppUser findByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}
