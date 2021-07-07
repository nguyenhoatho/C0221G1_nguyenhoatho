package com.casestudy.casestudi.controller.employee;


import com.casestudy.casestudi.model.entity.employee.AppUser;
import com.casestudy.casestudi.model.entity.employee.Employee;
import com.casestudy.casestudi.model.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IAppRoleService appRoleService;

    @Autowired
    IAppUserService appUserService;
//    @Autowired
//    BCryptPasswordEncoder cryptPasswordEncoder;
    @Autowired
    IUserRoleService userRoleService;


    @RequestMapping(value = "/create-employee")
    public String showCreate(Model model){
        model.addAttribute("educationList",educationDegreeService.findAdd());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("divisionList",divisionService.findAdd());
        model.addAttribute("employee",new Employee());
        model.addAttribute("user",new AppUser());
        model.addAttribute("roleList",appRoleService.findAll());
        return "/employee/create";
    }

    @PostMapping(value = "/create")
    public String createEmployee(@ModelAttribute Employee employee, @ModelAttribute(name = "user") AppUser user, Model model,
                                 @RequestParam Long[] role){
//        for(AppUser appUser : appUserService.findAll()){
//            if(appUser.getUserName().equals(user.getUserName())){
//                model.addAttribute("message","Error");
//            }
//        }
//        user.setEncrytedPassword(cryptPasswordEncoder.encode(user.getEncrytedPassword()));
//        user.setEnabled(true);
        appUserService.save(user);
        employee.setUser(user);
        employeeService.save(employee);
        for(int i = 0 ; i < role.length;i++){
            userRoleService.save(user,role[i].longValue());
        }
        model.addAttribute("message","Successfull");
        return "/employee/create";
    }

    @GetMapping(value = "/")
    public ModelAndView showListEmployee(@PageableDefault(value = 5) Pageable pageable, @RequestParam(name = "nameSearch") Optional<String> nameSearch){
        String keywordValue = "";
        Page<Employee> employeeList;
        ModelAndView modelAndView = new ModelAndView("employee/list_employee");
        if(nameSearch.isPresent()){
            keywordValue = nameSearch.get();
        }
        employeeList = this.employeeService.findAll(pageable,keywordValue);
        modelAndView.addObject("keywordValue",keywordValue);
        modelAndView.addObject("employeeList",employeeList);
        return modelAndView;
    }
    @GetMapping("/edit")
    public String showEditEmployee(@RequestParam int id, Model model){
        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("educationList",educationDegreeService.findAdd());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("divisionList",divisionService.findAdd());
        return "employee/edit";
    }
    @PostMapping(value = "/edit")
    public String editEmployee(@ModelAttribute Employee employee){
        this.employeeService.edit(employee);
        return "redirect:/employee/";
    }
    @GetMapping(value = "/delete")
    public String deleteEmployee(@RequestParam int id){
        Employee employee=employeeService.findById(id);
        employee.setFlag(0);
        employeeService.delete(employee);
        return "redirect:/employee/";
    }
}
