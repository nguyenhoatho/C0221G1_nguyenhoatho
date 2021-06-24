package com.example.update.model.repository;

import com.example.update.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Integer> {
//    Page<Blog> findAllByTittleContaining(Pageable pageable, String keywork );
//    @Query(value="SELECT * FROM blog where tittle like :keywork order by day_of_create;", nativeQuery=true)
//    Page<Blog> getBlogSearch(Pageable pageable, @Param("keywork") String keywork);
        Page<Blog>findAllByTittleContainingOrderByDayOfCreate(Pageable pageable, String keywork);
}