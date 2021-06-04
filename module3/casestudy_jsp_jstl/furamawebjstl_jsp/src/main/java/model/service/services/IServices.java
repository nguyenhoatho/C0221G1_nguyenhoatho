package model.service.services;


import model.bean.Services;

public interface IServices {
    public boolean createVillaService(Services services);
    public boolean createHouseService(Services services);
    public boolean createHomeService(Services services);
}
