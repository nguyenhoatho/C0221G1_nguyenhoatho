package com.example.update.model.repository;

import com.example.update.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    Page<Blog> findAllByTittleContaining(Pageable pageable, String keywork );


}
