package com.example.blog.model.service;


import com.example.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAllByTittle(String keywork, Integer flag, Pageable pageable);
    Optional<Blog> findId(Integer id);
    Blog findByNameAuthor(String NameAuthor);
    Blog findByNameTittle(String tittle);
    void deleteBlog(Integer id);
    void save(Blog blog);
    void edit(Blog blog);
    List<Blog> findBlogByNameCategory(String nameCategory);


}
