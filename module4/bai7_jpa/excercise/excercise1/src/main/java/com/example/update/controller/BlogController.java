package com.example.update.controller;

import com.example.update.model.entity.Blog;
import com.example.update.model.entity.Category;
import com.example.update.model.service.IBlogService;
import com.example.update.model.service.ICategoryService;
import com.example.update.model.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping(value = {"/"})
    public String showBlog(Model model, @PageableDefault(size = 3)Pageable pageable,
                           @RequestParam Optional<String> keywork){
        String keyworkValue="";
        if (keywork.isPresent()){
            keyworkValue=keywork.get();
        }
        Page<Blog> blogs=blogService.findAllByTittle(pageable,keyworkValue);

        model.addAttribute("keyworkvalue",keyworkValue);
        model.addAttribute("blog",blogs);
        return "listblog";
    }
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryService.findAll());
        return "/create";
    }
    @PostMapping(value = {"/create"})
    public String creatBlog(@ModelAttribute Blog blog){
        blog.setDayOfCreate(new Date());
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping(value = {"blog/view"})
    public String showView(@RequestParam Integer id,Model model){
        model.addAttribute("blog",blogService.findId(id));
        return "view";
    }
    @GetMapping(value = {"blog/edit"})
    public String showEdit(@RequestParam Integer id,Model model){
        model.addAttribute("blog",blogService.findId(id).get());
        model.addAttribute("cate",categoryService.findAll());
        return "edit";
    }
    @PostMapping(value = {"/edit"})
    public String editBlog(@ModelAttribute Blog blog){
        blogService.edit(blog);
        return "redirect:/";
    }
    @GetMapping(value = {"blog/delete"})
    public String deleteBlog(@RequestParam Integer id){
        blogService.deleteBlog(id);
        return "redirect:/";
    }
    @GetMapping(value = {"/listCategory"})
    public String showCategory(Model model){
        Iterable<Category> categories=categoryService.findAll();
        model.addAttribute("category",categories);
        return "listcategory";
    }
    @GetMapping(value = {"/createCategory"})
    public String ShowFormCategory(Model model){
        model.addAttribute("category",new Category());
        return "createCategory";
    }
    @PostMapping(value = {"/createCategory"})
    public String createCategory(@ModelAttribute Category category){
        categoryService.saveCategory(category);
        return "redirect:/listCategory";
    }
    @GetMapping(value = {"/category/edit"})
    public String showFormCatefory(@RequestParam Integer id, Model model){
        model.addAttribute("category",categoryService.findById(id).get());
        return "editCategory";
    }
    @PostMapping(value = {"/editCategory"})
    public String editCategory(@ModelAttribute Category category){
        categoryService.editCategory(category);
        return "redirect:/listCategory";
    }
    @GetMapping(value = {"/category/view"})
    public String showFormView(@RequestParam Integer id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "viewCategory";
    }
    @GetMapping(value = {"/category/delete"})
    public String deleteCategory(@RequestParam Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/listCategory";
    }

}
