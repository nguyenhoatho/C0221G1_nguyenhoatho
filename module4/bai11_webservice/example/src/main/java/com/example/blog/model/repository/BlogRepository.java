package com.example.blog.model.repository;


import com.example.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Integer> {
//    Page<Blog> findAllByTittleContaining(Pageable pageable, String keywork );
//    @Query(value="SELECT * FROM blog where tittle like :keywork order by day_of_create;", )
//    Page<Blog> getBlogSearch(Pageable pageable, @Param("keywork") String keywork);
//        @Query()
//       @Query(value="select c from Blog c join Category on Category .id=c.idBlog where c.tittle like %?1% and " +
//               "Category .flag=1 order by c.dayOfCreate",nativeQuery=false)
        @Query(value="select c from Blog c join Category  a on a.id=c.category.id where c.tittle like %?1% and a.flag=?2" +
                " order by c.dayOfCreate ")
        Page<Blog> searchName (String keywork, Integer flag, Pageable pageable);
        @Query(value="select blog from Blog blog join Category  category on category.id=blog.category.id where category.categoryName like %?3%")
        List<Blog> findBlogByNameCategory(String nameCategory);
}
