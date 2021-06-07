package model.service;


import model.bean.Position;

import java.util.List;

public interface IPosition {
    public Position findPositionByID(int id);
    public List<Position> getAllPosition();
}
