package com.casestudy.casestudi.model.service.service.Impl;

;
import com.casestudy.casestudi.model.entity.service.RentType;
import com.casestudy.casestudi.model.repository.service.IRentTypeRepository;
import com.casestudy.casestudi.model.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository repository;

    @Override
    public List<RentType> findAll() {
        return repository.findAll();
    }
}
