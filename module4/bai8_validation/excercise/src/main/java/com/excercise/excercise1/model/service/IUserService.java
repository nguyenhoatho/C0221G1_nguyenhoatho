package com.excercise.excercise1.model.service;

import com.excercise.excercise1.model.entity.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);

    List<User> findAll();
}
