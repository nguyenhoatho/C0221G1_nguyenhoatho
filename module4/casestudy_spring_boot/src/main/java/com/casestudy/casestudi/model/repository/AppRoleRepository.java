package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.AppRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends PagingAndSortingRepository<AppRole,Long> {
}
