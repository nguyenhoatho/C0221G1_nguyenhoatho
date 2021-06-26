package com.excercise.excercise1.model.service.impl;

import com.excercise.excercise1.model.entity.User;
import com.excercise.excercise1.model.repository.UserRepository;
import com.excercise.excercise1.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
