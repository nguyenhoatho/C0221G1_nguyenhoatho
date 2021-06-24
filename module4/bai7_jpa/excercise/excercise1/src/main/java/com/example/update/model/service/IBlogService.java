package com.example.update.model.service;

import com.example.update.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAllByTittle(Pageable pageable,String keywork);
    Optional<Blog> findId(Integer id);
    Blog findByNameAuthor(String NameAuthor);
    Blog findByNameTittle(String tittle);
    void deleteBlog(Integer id);
    void save(Blog blog);
    void edit(Blog blog);


}
