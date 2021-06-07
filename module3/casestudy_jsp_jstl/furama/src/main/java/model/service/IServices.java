package model.service;



import model.bean.Employee;
import model.bean.Services;

import java.util.List;

public interface IServices {
    public boolean createService(Services services);
    public Services findServiceByID(String id);
    public List<Services> getAllServices();
}
