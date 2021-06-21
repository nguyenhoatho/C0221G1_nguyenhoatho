package com.practice.model.service.Impl;

import com.practice.model.bean.Commend;
import com.practice.model.repository.ICommendRepository;
import com.practice.model.service.ICommedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommedServiceImpl implements ICommedService {

    @Autowired
    private ICommendRepository commendRepository;

    @Override
    public List<Commend> findAll() {
        return commendRepository.findAll();
    }

    @Override
    public void save(Commend comment) {
        commendRepository.save(comment);
    }

    @Override
    public Commend update(Commend comment) {
        return commendRepository.update(comment);
    }

    @Override
    public Commend like(Long id) {
        return commendRepository.like(id);
    }

    @Override
    public Commend findById(Long id) {
        return commendRepository.findById(id);
    }
}
