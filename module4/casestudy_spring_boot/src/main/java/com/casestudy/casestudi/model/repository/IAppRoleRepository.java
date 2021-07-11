package com.casestudy.casestudi.model.repository;

import com.casestudy.casestudi.model.entity.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppRoleRepository extends PagingAndSortingRepository<AppRole, Long> {
}
