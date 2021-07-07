package com.casestudy.casestudi.model.service.employee;



import com.casestudy.casestudi.model.entity.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
