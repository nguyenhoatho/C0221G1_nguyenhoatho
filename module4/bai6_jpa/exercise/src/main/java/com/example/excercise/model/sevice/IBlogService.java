package com.example.excercise.model.sevice;

import com.example.excercise.model.entity.Blog;

import java.util.List;

public interface IBlogService {
     void saveBlog(Blog blog);
     List<Blog> findAll();
     Blog findId(Integer id);
     Blog updateBlog(Blog blog);
     void deleteBlog(Integer id);

}
