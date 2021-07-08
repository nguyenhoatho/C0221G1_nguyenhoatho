package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.Division;
import com.casestudy.casestudi.model.repository.IDivisionRepository;
import com.casestudy.casestudi.model.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findDivisionByAll() {
        return (List<Division>) iDivisionRepository.findAll();
    }
}
