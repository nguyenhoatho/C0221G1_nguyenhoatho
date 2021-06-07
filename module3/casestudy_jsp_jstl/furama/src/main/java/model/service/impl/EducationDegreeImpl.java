package model.service.impl;

import model.bean.EducationDegree;
import model.repository.education_degree.EducationDegreeRepository;
import model.service.IEducationDegree;

import java.util.List;

public class EducationDegreeImpl implements IEducationDegree {
    EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    public EducationDegree findEducationDegreeByID(int id) {
        return educationDegreeRepository.findEducationDegreeByID(id);
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return educationDegreeRepository.getAllEducationDegree();
    }
}
