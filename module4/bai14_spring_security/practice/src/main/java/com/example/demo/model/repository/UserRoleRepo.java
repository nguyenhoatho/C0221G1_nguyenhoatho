package com.example.demo.model.repository;

import com.example.demo.model.entity.AppUser;
import com.example.demo.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepo extends JpaRepository <UserRole,Long>{
    List<UserRole> findByAppUser(AppUser appUser);
}
