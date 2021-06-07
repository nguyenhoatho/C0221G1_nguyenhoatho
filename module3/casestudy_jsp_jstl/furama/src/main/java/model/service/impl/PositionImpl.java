package model.service.impl;

import model.bean.Position;
import model.repository.position.PositionRepository;
import model.service.IPosition;

import java.util.List;

public class PositionImpl implements IPosition {
    PositionRepository positionRepository = new PositionRepository();
    @Override
    public Position findPositionByID(int id) {
        return positionRepository.findPositionByID(id);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
