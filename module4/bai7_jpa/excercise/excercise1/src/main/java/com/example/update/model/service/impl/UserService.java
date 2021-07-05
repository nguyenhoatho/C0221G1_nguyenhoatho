package com.example.update.model.service.impl;

import com.example.update.model.entity.User;
import com.example.update.model.repository.UserRepository;
import com.example.update.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User findUSer(String userName) {
      return userRepository.findByName(userName);
    }
}
