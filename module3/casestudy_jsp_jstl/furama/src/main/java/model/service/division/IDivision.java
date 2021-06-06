package model.service.division;


import model.bean.Division;

import java.util.List;

public interface IDivision {
    public Division findDivisionByID(int id);
    public List<Division> getAllDivision();
}
