package com.example.blog.controller;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.entity.Category;
import com.example.blog.model.repository.BlogRepository;
import com.example.blog.model.service.IBlogService;
import com.example.blog.model.service.ICategoryService;
import com.sun.javafx.scene.control.skin.LabeledSkinBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = {"/{keywork}"})
    public ResponseEntity<Page<Blog>> finAllBlog(@PageableDefault(size = 2) Pageable pageable, @PathVariable String keywork){
        String keyworkValue="";
//        if (keywork.isEmpty()){
//            keyworkValue=keywork.;
//        }
        Page<Blog> blogs=blogService.findAllByTittle(keywork, 1, pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);

    }
    @GetMapping(value = {"/listCategory"})
    public  ResponseEntity<List<Category>> findAllCateGory(){
        List<Category>categoryList=categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @GetMapping(value = {"/listBlog/{id}"})
    public  ResponseEntity<List<Blog>> findBlogByCategoryName(@PathVariable Integer id){
        Optional<Category> category=categoryService.findById(id);
        if (category.get()==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category.get().getBlogList(),HttpStatus.OK);

    }
    @GetMapping(value = "/blog/{id}")
    public ResponseEntity<Blog> findBlogDetail(@PathVariable Integer id){
        Optional<Blog> blog=blogService.findId(id);
        if (blog.get()==null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }


}
