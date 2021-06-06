package model.service.education_degree.impl;

import model.bean.EducationDegree;
import model.repository.education_degree.EducationDegreeRepo;
import model.service.education_degree.IEducationDegree;

import java.util.List;

public class EducationDegreeImpl implements IEducationDegree {
    EducationDegreeRepo educationDegreeRepository = new EducationDegreeRepo();
    @Override
    public EducationDegree findEducationDegreeByID(int id) {
        return educationDegreeRepository.findEducationDegreeByID(id);
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return educationDegreeRepository.getAllEducationDegree();
    }
}
