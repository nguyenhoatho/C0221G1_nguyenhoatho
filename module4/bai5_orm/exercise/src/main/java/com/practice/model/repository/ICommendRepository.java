package com.practice.model.repository;

import com.practice.model.bean.Commend;

import java.util.List;

public interface ICommendRepository {
    List<Commend> findAll();

    void save(Commend comment);

    Commend update(Commend comment);

    Commend like(Long id);

    Commend findById(Long id);
}
