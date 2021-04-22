package service.house;

import models.House;
import repository.FuncWriteAndReadFileCsv;

public interface HouseService extends FuncWriteAndReadFileCsv<House> {
    void addNewHouse();
    void showAllHouse();
    House getHouseById(int id);
    void showAllHouseNotDuplicate();
}
