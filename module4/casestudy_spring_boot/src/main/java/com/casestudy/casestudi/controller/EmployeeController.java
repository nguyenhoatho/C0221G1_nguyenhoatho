package com.casestudy.casestudi.controller;




import com.casestudy.casestudi.dto.EmployeeDto;
import com.casestudy.casestudi.model.entity.Employee;
import com.casestudy.casestudi.model.service.IDivisionService;
import com.casestudy.casestudi.model.service.IEducationDegreeService;
import com.casestudy.casestudi.model.service.IEmployeeService;
import com.casestudy.casestudi.model.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IEducationDegreeService iEducationDegreeService;
    @Autowired
    IDivisionService iDivisionService;
    @RequestMapping(value = "/list")
    public String showListEmployee(@RequestParam(name = "search") Optional<String> search , @PageableDefault(size = 2) Pageable pageable, Model model) {
        String name="";
        if(search.isPresent()){
            name = search.get();
        }
        Page<Employee> employees = iEmployeeService.findEmployeeByName(name,pageable);
        model.addAttribute("listEmployee", employees);
        model.addAttribute("name", name);
        return "/employee/list-employee";
    }

    @RequestMapping(value = "/createForm")
    public String goCreateForm(Model model) {
        model.addAttribute("positionList", iPositionService.findPositionByAll());
        model.addAttribute("divisionList", iDivisionService.findDivisionByAll());
        model.addAttribute("educationList", iEducationDegreeService.findEducationDegreeByAll());
        model.addAttribute("employee", new EmployeeDto());
        return "employee/create-employee";
    }

    @PostMapping(value = "/create")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("positionList", iPositionService.findPositionByAll());
            model.addAttribute("divisionList", iDivisionService.findDivisionByAll());
            model.addAttribute("educationList", iEducationDegreeService.findEducationDegreeByAll());
            return "employee/create-employee";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employee.setEmployeeFlag(true);
            iEmployeeService.save(employee);
            model.addAttribute("message", "New customer created successfully");
            return "redirect:/employee/list";
        }
    }

    @RequestMapping(value = "/view/{id}")
    public String goViewForm(@PathVariable Integer id, Model model) {
        try {
            Optional<Employee> employee = iEmployeeService.findEmployeeById(id);
            model.addAttribute("employee", employee.get());
            return "/employee/view-employee";
        } catch (Exception e) {
            return "/error.404";
        }
    }

    @RequestMapping(value = "/edit/{id}")
    public String goEditForm(@PathVariable Integer id, Model model) {
        try {
            Optional<Employee> employee = iEmployeeService.findEmployeeById(id);
            model.addAttribute("positionList", iPositionService.findPositionByAll());
            model.addAttribute("divisionList", iDivisionService.findDivisionByAll());
            model.addAttribute("educationList", iEducationDegreeService.findEducationDegreeByAll());
            model.addAttribute("employee", employee.get());
            return "/employee/edit-employee";
        } catch (Exception e) {
            return "/error.404";
        }
    }

    @PostMapping(value = "/edit-employee")
    public String updateEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto,BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("positionList", iPositionService.findPositionByAll());
            model.addAttribute("divisionList", iDivisionService.findDivisionByAll());
            model.addAttribute("educationList", iEducationDegreeService.findEducationDegreeByAll());
            return "employee/edit-employee";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employee.setEmployeeFlag(true);
            iEmployeeService.save(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id){
        Employee employee = iEmployeeService.findEmployeeById(id).orElse(null);
        employee.setEmployeeFlag(false);
        iEmployeeService.save(employee);
        return "redirect:/employee/list";
    }
}
