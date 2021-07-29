package com.casestudy.casestudi.controller;


import com.casestudy.casestudi.dto.CustomerDto;
import com.casestudy.casestudi.model.entity.Customer;
import com.casestudy.casestudi.model.service.ICustomerService;
import com.casestudy.casestudi.model.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @RequestMapping(value = "/list")
    public ResponseEntity<Page<Customer>> showListCustomer(@RequestParam Optional<String> search , @PageableDefault(size = 3) Pageable pageable) {
        String name="";
        if(search.isPresent()){
            name = search.get();
        }
        Page<Customer> customers = iCustomerService.findCustomerByName(name,pageable);
//        model.addAttribute("listCustomer", customers);
//        model.addAttribute("name", name);
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @RequestMapping(value = "/createForm")
    public String goCreateForm(Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findCustomerTypeByAll());
        model.addAttribute("customer", new CustomerDto());
        return "customer/create-customer";
    }

    @PostMapping(value = "/create")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, Model model) {
       if(bindingResult.hasErrors()){
           model.addAttribute("customerTypeList", iCustomerTypeService.findCustomerTypeByAll());
           return "customer/create-customer";
       }else {
           Customer customer = new Customer();
           BeanUtils.copyProperties(customerDto, customer);
           customer.setCustomerFlag(true);
           iCustomerService.save(customer);
           model.addAttribute("message", "New customer created successfully");
           return "redirect:/customer/list";
       }
    }

    @RequestMapping(value = "/view/{id}")
    public String goViewForm(@PathVariable String id, Model model) {
        try {
            Optional<Customer> customer = iCustomerService.findCustomerById(id);
            model.addAttribute("customer", customer.get());
            return "/customer/view-customer";
        } catch (Exception e) {
            return "/error.404";
        }
    }

    @RequestMapping(value = "/edit/{id}")
    public String goEditForm(@PathVariable String id, Model model) {
        try {
            Optional<Customer> customer = iCustomerService.findCustomerById(id);
            model.addAttribute("customerTypeList", iCustomerTypeService.findCustomerTypeByAll());
            model.addAttribute("customer", customer.get());
            return "/customer/edit-customer";
        } catch (Exception e) {
            return "/error.404";
        }
    }

    @PostMapping(value = "/edit-customer")
    public String updateCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto,BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", iCustomerTypeService.findCustomerTypeByAll());
            return "customer/edit-customer";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setCustomerFlag(true);
            iCustomerService.save(customer);
//            model.addAttribute("customer", customer);
//            model.addAttribute("customerTypeList", iCustomerTypeService.findCustomerTypeByAll());
            model.addAttribute("message", "Customer updated successfully");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam String id){
        Customer customer = iCustomerService.findCustomerById(id).orElse(null);
        customer.setCustomerFlag(false);
        iCustomerService.save(customer);
        return "redirect:/customer/list";
    }
}
