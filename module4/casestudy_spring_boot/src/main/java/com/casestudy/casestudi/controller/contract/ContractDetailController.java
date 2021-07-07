package com.casestudy.casestudi.controller.contract;


import com.casestudy.casestudi.model.entity.contract.ContractDetail;
import com.casestudy.casestudi.model.service.contract.IAttachServiceService;
import com.casestudy.casestudi.model.service.contract.IContractDetailService;
import com.casestudy.casestudi.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/contract-detail")
public class ContractDetailController {
    @Autowired
    IAttachServiceService attachServiceService;
    @Autowired
    IContractService contractService;
    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping("/create-contract-detail")
    public String showCreateContractDetail(Model model){
        model.addAttribute("attachServiceList",attachServiceService.findAll());
        model.addAttribute("contractList",contractService.findAll());
        model.addAttribute("contractDetail",new ContractDetail());
        return "contract/contract-detail-create";
    }
    @PostMapping("/create")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        return "contract/contract-detail-create";
    }
}
