package com.casestudy.casestudi.model.service.employee.Impl;

import com.casestudy.casestudi.model.entity.employee.EducationDegree;
import com.casestudy.casestudi.model.repository.employee.IEducationDegreeRepository;
import com.casestudy.casestudi.model.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAdd() {
        return educationDegreeRepository.findAll();
    }
}
