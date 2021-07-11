package com.casestudy.casestudi.controller;

import java.security.Principal;
import java.util.List;


import com.casestudy.casestudi.config.WebSecurityConfig;
import com.casestudy.casestudi.model.entity.AppRole;
import com.casestudy.casestudi.model.entity.AppUser;
import com.casestudy.casestudi.model.entity.UserRole;
import com.casestudy.casestudi.model.service.impl.UserDetailsServiceImpl;
import com.casestudy.casestudi.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String goIndexPage(Model model, Principal principal) {
        return "/index";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "adminPage";
//    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginForm(){
        return "login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return "index";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "error.404";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String showFormCreate(Model model){
        List<AppRole> appRoleList = userDetailsService.findAllAppRole();
        model.addAttribute("appUser",new AppUser());
        model.addAttribute("appRole",appRoleList);
        return "create-user";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@ModelAttribute AppUser appUser, @RequestParam Long roleID,Model model){
        WebSecurityConfig webSecurityConfig = new WebSecurityConfig();
        String password = webSecurityConfig.passwordEncoder().encode(appUser.getEncrytedPassword());
        appUser.setEncrytedPassword(password);
        AppRole appRole = userDetailsService.findAppRoleById(roleID);
        userDetailsService.saveAppUser(appUser);
        UserRole userRole = new UserRole(appUser,appRole);
        userDetailsService.saveUserRole(userRole);
        model.addAttribute("msg","Tạo tài khoản thành công");
        return "login";
    }
    
}
