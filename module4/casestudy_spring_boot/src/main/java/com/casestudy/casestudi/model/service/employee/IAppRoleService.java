package com.casestudy.casestudi.model.service.employee;



import com.casestudy.casestudi.model.entity.employee.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findAll();
    AppRole findById(Long id);
}