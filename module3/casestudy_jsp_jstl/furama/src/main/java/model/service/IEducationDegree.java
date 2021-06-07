package model.service;



import model.bean.EducationDegree;

import java.util.List;

public interface IEducationDegree {
    public EducationDegree findEducationDegreeByID(int id);
    public List<EducationDegree> getAllEducationDegree();
}
