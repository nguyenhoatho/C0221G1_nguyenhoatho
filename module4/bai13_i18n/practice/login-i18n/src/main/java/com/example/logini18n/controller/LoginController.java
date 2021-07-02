package com.example.logini18n.controller;

import com.example.logini18n.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "/login";
    }
    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute User user) {
        if(user.getName().equals("admin") && user.getPassword().equals("123456")){
            ModelAndView modelAndView = new ModelAndView("/success");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        return new ModelAndView("/error");
    }
}
