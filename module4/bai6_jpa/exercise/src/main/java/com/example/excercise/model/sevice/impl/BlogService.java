package com.example.excercise.model.sevice.impl;

import com.example.excercise.model.entity.Blog;
import com.example.excercise.model.repository.IBlogRepository;
import com.example.excercise.model.sevice.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public void saveBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {

        return iBlogRepository.findAll();
    }

    @Override
    public Blog findId(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return iBlogRepository.saveAndFlush(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        iBlogRepository.deleteById(id);
    }
}
