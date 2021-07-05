package com.example.update.model.repository;

import com.example.update.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select user from User  user where user.UserName like %?1%")
    User findByName(String userName);
}
