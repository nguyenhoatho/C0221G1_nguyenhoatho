package com.casestudy.casestudi.controller.customer;


import com.casestudy.casestudi.model.entity.customer.Customer;
import com.casestudy.casestudi.model.service.customer.ICustomerService;
import com.casestudy.casestudi.model.service.customer.ICustomerTypeService;
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
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;
    @GetMapping("/")
    public String showhome(){
        return "homePage";
    }
    @GetMapping("/customer")
    public ModelAndView showListCustomer(@PageableDefault(value = 5)Pageable pageable, @RequestParam(name = "nameSearch") Optional<String> nameSearch){
        String keywordValue = "";
        Page<Customer> customerList;
        ModelAndView modelAndView = new ModelAndView("customer/list_customer");
        if(nameSearch.isPresent()){
            keywordValue = nameSearch.get();
        }
        customerList = this.customerService.findAllByNameBlogContaining(keywordValue,pageable);
        modelAndView.addObject("keywordValue",keywordValue);
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public String showListCustomer(Model model){
        model.addAttribute("customerType",this.customerTypeService.findAll());
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Customer customer){
        this.customerService.save(customer);
        return "redirect:/customer/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id,Model model){
        model.addAttribute("customer",this.customerService.findById(id));
        model.addAttribute("customerType",this.customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/edit-customer")
    public String editCustomer(@ModelAttribute Customer customer){
        this.customerService.edit(customer);
        return "redirect:/customer/";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id){
        Customer customer=customerService.findById(id);
        customer.setFlag(0);
        customerService.edit(customer);
        return "redirect:/customer/";
    }

}
