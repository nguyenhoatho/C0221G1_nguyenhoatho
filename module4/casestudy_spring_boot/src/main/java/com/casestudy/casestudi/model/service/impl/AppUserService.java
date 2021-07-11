package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.AppUser;
import com.casestudy.casestudi.model.repository.IAppUserRepository;
import com.casestudy.casestudi.model.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    IAppUserRepository iAppUserRepository;
    @Override
    public void save(AppUser appUser) {
        iAppUserRepository.save(appUser);
    }
}
