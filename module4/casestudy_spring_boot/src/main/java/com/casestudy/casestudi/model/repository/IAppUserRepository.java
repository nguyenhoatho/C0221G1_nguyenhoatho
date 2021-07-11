package com.casestudy.casestudi.model.repository;


import com.casestudy.casestudi.model.entity.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends PagingAndSortingRepository<AppUser,Long> {
}
