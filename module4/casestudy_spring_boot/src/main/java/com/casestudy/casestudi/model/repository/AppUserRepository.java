package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository  extends PagingAndSortingRepository<AppUser,Long> {
    AppUser findByUserName(String name);
}
