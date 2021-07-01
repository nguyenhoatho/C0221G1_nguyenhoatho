package com.example.blogajax.model.service.Impl;

import com.example.blogajax.model.entity.Blog;
import com.example.blogajax.model.repository.IBlogRepository;
import com.example.blogajax.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog(Integer number) {
        return blogRepository.findAll(number);
    }

    @Override
    public List<Blog> findAllByName(String name) {
        return blogRepository.findAllByName(name);
    }
}
