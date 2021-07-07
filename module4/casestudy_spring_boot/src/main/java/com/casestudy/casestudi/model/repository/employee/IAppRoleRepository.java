package com.casestudy.casestudi.model.repository.employee;


import com.casestudy.casestudi.model.entity.employee.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
//    List<UserRole> findByAppUser(AppUser appUser);
}