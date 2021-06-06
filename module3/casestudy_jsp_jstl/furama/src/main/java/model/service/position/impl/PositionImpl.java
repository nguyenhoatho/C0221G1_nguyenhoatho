package model.service.position.impl;

import model.bean.Position;
import model.repository.position.PositionRepo;
import model.service.position.IPosition;

import java.util.List;

public class PositionImpl implements IPosition {
    PositionRepo positionRepository = new PositionRepo();
    @Override
    public Position findPositionByID(int id) {
        return positionRepository.findPositionByID(id);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
