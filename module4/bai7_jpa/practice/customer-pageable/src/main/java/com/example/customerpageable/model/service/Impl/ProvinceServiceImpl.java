package com.example.customerpageable.model.service.Impl;

import com.example.customerpageable.model.entity.province.Province;
import com.example.customerpageable.model.repository.IProvinceRepository;
import com.example.customerpageable.model.service.IProviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceServiceImpl implements IProviceService {
    @Autowired
    IProvinceRepository repository;
    @Override
    public Iterable<Province> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Province province) {
        repository.save(province);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
