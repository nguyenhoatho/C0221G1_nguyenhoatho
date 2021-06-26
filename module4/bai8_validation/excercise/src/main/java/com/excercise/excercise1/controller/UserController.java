package com.excercise.excercise1.controller;

import com.excercise.excercise1.dto.UserDto;
import com.excercise.excercise1.model.entity.User;
import com.excercise.excercise1.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/")
    public String showIndex(Model model){

        model.addAttribute("userController",userService.findAll());
        return "index";
    }
    @GetMapping(value = {"/creatUser"})
    public String showFormCreateUser(Model model){
        model.addAttribute("userDto", new UserDto());
        return "addUser";
    }
    @PostMapping(value = {"createUser/createUser"})
    public String createUser(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
            new UserDto().validate(userDto,bindingResult);
            if (bindingResult.hasErrors()){
                return "/addUser";
            }
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            redirectAttributes.addFlashAttribute("msg","tao thanh cong");
            userService.saveUser(user);
            return "redirect:/";

    }}

//            (@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult,
//                            RedirectAttributes redirectAttributes, @RequestParam String birthDay) throws ParseException {
//
//        new UserDto().validate(userDto,bindingResult);
//
//        if (bindingResult.hasErrors()){
//            return "index";
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar dob = Calendar.getInstance();
//        dob.setTime(sdf.parse(birthDay));
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        userDto.setAge(year);
//        User user=new User();
//        BeanUtils.copyProperties(userDto,user);
//        userService.saveUser(user);
//
//        redirectAttributes.addFlashAttribute("msg","ban da dang ki thanh cong");
//        return "redirect:/";
//    }

