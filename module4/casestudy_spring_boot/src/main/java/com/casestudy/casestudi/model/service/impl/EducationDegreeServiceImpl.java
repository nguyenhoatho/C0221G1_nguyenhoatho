package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.EducationDegree;
import com.casestudy.casestudi.model.repository.IEducationDegreeRepository;
import com.casestudy.casestudi.model.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;
    @Override
    public List<EducationDegree> findEducationDegreeByAll() {
        return (List<EducationDegree>) iEducationDegreeRepository.findAll();
    }
}
