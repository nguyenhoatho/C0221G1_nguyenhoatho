package com.example.blogajax.controller;

import com.example.blogajax.model.entity.Blog;
import com.example.blogajax.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "http://localhost:63342")
public class BlogController {
    private static Integer number = 1;
    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> showBlog(){
        List<Blog> blogList = this.blogService.findAllBlog(number);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/load")
    public ResponseEntity<List<Blog>> loadMoreList(){
        number += 1;
        List<Blog> blogList = this.blogService.findAllBlog(number);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping(value = "/search/{keyword}")
    public ResponseEntity<List<Blog>> searchByName(@PathVariable String keyword){
        List<Blog> blogList = this.blogService.findAllByName(keyword);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }
}
