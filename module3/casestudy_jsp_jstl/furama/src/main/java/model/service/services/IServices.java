package model.service.services;



import model.bean.Employee;
import model.bean.Services;

import java.util.List;

public interface IServices {
    public boolean createVillaService(Services services);
    public boolean createHouseService(Services services);
    public boolean createRoomService(Services services);
    public Services findServiceByID(int id);
    public List<Services> getAllServices();
}
