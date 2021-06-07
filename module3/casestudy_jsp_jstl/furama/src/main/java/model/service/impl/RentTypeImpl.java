package model.service.impl;

import model.bean.RentType;
import model.repository.rent_type.RentTypeRepository;
import model.service.IRentType;

import java.util.List;

public class RentTypeImpl implements IRentType {
    RentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public RentType findRentTypeByID(int id) {
        return rentTypeRepository.findRentTypeByID(id);
    }

    @Override
    public List<RentType> getAllRentType() {
        return rentTypeRepository.getAllRentType();
    }
}
