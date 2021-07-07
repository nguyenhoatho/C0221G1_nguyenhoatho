package com.casestudy.casestudi.model.service.employee.Impl;


import com.casestudy.casestudi.model.entity.employee.Division;
import com.casestudy.casestudi.model.repository.employee.IDivisionRepository;
import com.casestudy.casestudi.model.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAdd() {
        return divisionRepository.findAll();
    }
}
