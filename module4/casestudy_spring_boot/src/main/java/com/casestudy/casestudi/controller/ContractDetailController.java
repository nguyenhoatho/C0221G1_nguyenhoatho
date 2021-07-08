package com.casestudy.casestudi.controller;


import com.casestudy.casestudi.dto.ContractDetailDto;
import com.casestudy.casestudi.model.entity.ContractDetail;
import com.casestudy.casestudi.model.service.IAttachServiceService;
import com.casestudy.casestudi.model.service.IContractDetailService;
import com.casestudy.casestudi.model.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "contract-detail")
public class ContractDetailController {
    @Autowired
    IContractDetailService iContractDetailService;
    @Autowired
    IAttachServiceService iAttachServiceService;
    @Autowired
    IContractService iContractService;
    @RequestMapping(value = "/list")
    public String showListContractDetail(@PageableDefault(size = 2) Pageable pageable, Model model) {
        Page<ContractDetail> contractDetails = iContractDetailService.findContractDetailByAll(pageable);
        model.addAttribute("listContractDetail", contractDetails);
        return "contract-detail/list-contract-detail";
    }
    @RequestMapping(value = "/createForm")
    public String goCreateForm(Model model) {
        model.addAttribute("contractDetail", new ContractDetailDto());
        model.addAttribute("attachList", iAttachServiceService.findAttachServiceByAll());
        model.addAttribute("contractList", iContractService.findAllContract());
        return "contract-detail/create-contract-detail";
    }

    @PostMapping(value = "/create")
    public String saveContract(@Valid @ModelAttribute("contractDetail") ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("attachList", iAttachServiceService.findAttachServiceByAll());
            model.addAttribute("contractList", iContractService.findAllContract());
            return "contract-detail/create-contract-detail";
        }else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            iContractDetailService.save(contractDetail);
            return "redirect:/contract-detail/list";
        }
    }
}
