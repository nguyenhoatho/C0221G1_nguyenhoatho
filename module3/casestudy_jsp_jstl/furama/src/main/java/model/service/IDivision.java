package model.service;


import model.bean.Division;

import java.util.List;

public interface IDivision {
    public Division findDivisionByID(int id);
    public List<Division> getAllDivision();
}
