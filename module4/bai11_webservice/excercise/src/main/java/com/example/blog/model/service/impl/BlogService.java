package com.example.blog.model.service.impl;


import com.example.blog.model.entity.Blog;
import com.example.blog.model.repository.BlogRepository;
import com.example.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

//    @Override
//    public Page<Blog> findAll(Pageable pageable,String keywork) {
//        return blogRepository.getBlogSearch(pageable,"%"+keywork+"%");
//    }

    @Override
    public Page<Blog> findAllByTittle(String keywork, Integer flag, Pageable pageable) {

        return blogRepository.searchName(keywork,1,pageable);
    }

    @Override
    public Optional<Blog> findId(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog findByNameAuthor(String NameAuthor) {
         return null;
    }

    @Override
    public Blog findByNameTittle(String tittle) {
        return null;
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public List<Blog> findBlogByNameCategory(String nameCategory) {
        return blogRepository.findBlogByNameCategory(nameCategory);
    }
}
