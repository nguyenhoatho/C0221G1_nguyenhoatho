package com.casestudy.casestudi.model.repository;

import com.casestudy.casestudi.model.entity.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends PagingAndSortingRepository<Position,Integer> {
}
