package com.casestudy.casestudi.model.repository.employee;


import com.casestudy.casestudi.model.entity.employee.AppUser;
import com.casestudy.casestudi.model.entity.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleUserRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}