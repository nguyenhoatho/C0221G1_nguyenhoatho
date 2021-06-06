package model.service.division.impl;

import model.bean.Division;
import model.repository.devision.DivisionRepository;
import model.service.division.IDivision;

import java.util.List;

public class DivisionImpl implements IDivision {
    DivisionRepository divisionRepository = new DivisionRepository();
    @Override
    public Division findDivisionByID(int id) {
        return divisionRepository.findDivisionByID(id);
    }

    @Override
    public List<Division> getAllDivision() {
        return divisionRepository.getAllDivision();
    }
}
