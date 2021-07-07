package com.casestudy.casestudi.controller.service;


import com.casestudy.casestudi.model.entity.service.Service;
import com.casestudy.casestudi.model.service.service.IRentTypeService;
import com.casestudy.casestudi.model.service.service.IServiceService;
import com.casestudy.casestudi.model.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    IServiceService serviceService;
    @Autowired
    IServiceTypeService serviceTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/create-service")
    public String showCreate(Model model){
        model.addAttribute("serviceType",this.serviceTypeService.findAll());
        model.addAttribute("rentType",this.rentTypeService.findAll());
        model.addAttribute("service",new Service());
        return "service/create";
    }
    @PostMapping("/create")
    public String createService(@ModelAttribute Service service){
        if(service.getStandardRoom() == null){
            service.setStandardRoom("0");
        }
        if(service.getDescription() == null){
            service.setDescription("0");
        }
        if(service.getPoolArea() == null){
            service.setPoolArea("0");
        }
        if(service.getNumberOfFloor() == null){
            service.setNumberOfFloor("0");
        }

        this.serviceService.save(service);
        return "/service/create";
    }
}
