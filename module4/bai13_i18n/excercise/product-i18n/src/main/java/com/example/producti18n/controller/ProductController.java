package com.example.producti18n.controller;

import com.example.producti18n.model.entity.Product;
import com.example.producti18n.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("list_product","productList",this.productService.findAll());
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "create_product";
    }
    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirect){
        redirect.addFlashAttribute("message","Successfull");
        this.productService.save(product);
        return "redirect:/";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product",product);
        return "/edit_product";
    }

    @PostMapping(value = "/edit-product")
    public String editProduct(@ModelAttribute Product product){
        this.productService.update(product);
        return "redirect:/";
    }
}
