package com.casestudy.casestudi.model.service.employee;



import com.casestudy.casestudi.model.entity.employee.AppUser;

import java.util.List;

public interface IAppUserService {
    AppUser findByUserName(String userName);
    void save(AppUser appUser);
    List<AppUser> findAll();
}