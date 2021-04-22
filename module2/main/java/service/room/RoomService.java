package service.room;

import models.Room;
import repository.FuncWriteAndReadFileCsv;

public interface RoomService extends FuncWriteAndReadFileCsv <Room> {
    void addNewRoom();
    void showAllRoom();
    Room getHouseById(int id);
    void showAllRoomNotDuplicate();


}
