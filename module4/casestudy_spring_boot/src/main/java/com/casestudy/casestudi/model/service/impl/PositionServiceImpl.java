package com.casestudy.casestudi.model.service.impl;


import com.casestudy.casestudi.model.entity.Position;
import com.casestudy.casestudi.model.repository.IPositionRepository;
import com.casestudy.casestudi.model.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;
    @Override
    public List<Position> findPositionByAll() {
        return (List<Position>) iPositionRepository.findAll();
    }
}
