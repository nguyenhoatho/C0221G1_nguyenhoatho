package com.practice.controller;

import com.practice.model.bean.Commend;
import com.practice.model.service.ICommedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommendController {

    @Autowired
    private ICommedService commentSvc;

    @GetMapping("/")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("commend", new Commend());
        List<Commend> commends = commentSvc.findAll();
        modelAndView.addObject("commends", commends);
        return modelAndView;
    }

    @PostMapping("/home")
    public String save(Commend commend) {
        commentSvc.save(commend);
        return "redirect:/";
    }

    @PostMapping(value = "/home/like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Commend> like(@PathVariable(name = "id") Long id) {
        Commend commend = commentSvc.like(id);
        System.out.println(commend.getLikeCount());
        if (commend == null) {
            return new ResponseEntity<>(commend, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commend, HttpStatus.OK);
    }

}
