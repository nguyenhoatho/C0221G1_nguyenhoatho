package com.example.blogajax.model.service;

import com.example.blogajax.model.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllBlog(Integer number);
    List<Blog> findAllByName(String name);
}
