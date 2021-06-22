package com.example.excercise.controller;

import com.example.excercise.model.entity.Blog;
import com.example.excercise.model.sevice.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {""})
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping(value = {"/"})
    public String homeBlog(Model model){
        model.addAttribute("listBlog",blogService.findAll());
        return "index";
    }
    @GetMapping(value = {"/create-blog"})
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping(value = {"/creat"})
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirect){
        blogService.saveBlog(blog);
        redirect.addFlashAttribute("message","tao thanh cong");
        return "redirect:/";
    }
    @GetMapping(value = "/blog/view")
    public String showViewBlog(@RequestParam int id, Model model){
        model.addAttribute("blog",blogService.findId(id));
        return "view";
    }
    @GetMapping(value = "/blog/edit")
    public String showEditBlog(@RequestParam int id, Model model){
        model.addAttribute("blog",blogService.findId(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String editBlog(@ModelAttribute Blog blog,RedirectAttributes redirect){

        blogService.updateBlog(blog);
        redirect.addFlashAttribute("message","sua thanh cong");
        return "redirect:/";
    }

    @GetMapping(value = "/blog/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirect){
        blogService.deleteBlog(id);
        redirect.addFlashAttribute("message","Delete xoa thanh cong");
        return "redirect:/";
    }
}
