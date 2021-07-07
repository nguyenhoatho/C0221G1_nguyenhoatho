package com.casestudy.casestudi.controller.contract;


import com.casestudy.casestudi.model.entity.contract.Contract;
import com.casestudy.casestudi.model.service.contract.IContractService;
import com.casestudy.casestudi.model.service.customer.ICustomerService;
import com.casestudy.casestudi.model.service.employee.IEmployeeService;
import com.casestudy.casestudi.model.service.service.IServiceService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IServiceService serviceService;
    @Autowired
    IContractService contractService;

    @GetMapping(value = "/create-contract")
    public String showCreate(Model model){
        model.addAttribute("employeeList",employeeService.listEmployee());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());
        model.addAttribute("contract",new Contract());
        return "/contract/create";
    }
    @PostMapping(value = "/create")
    public String createContract(@ModelAttribute Contract contract){
        this.contractService.save(contract);
        return "/contract/create";
    }

}
