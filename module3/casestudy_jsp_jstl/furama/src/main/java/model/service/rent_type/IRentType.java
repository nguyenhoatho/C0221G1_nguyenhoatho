package model.service.rent_type;

import model.bean.RentType;

import java.util.List;

public interface IRentType {
    public RentType findRentTypeByID(int id);
    public List<RentType> getAllRentType();
}
