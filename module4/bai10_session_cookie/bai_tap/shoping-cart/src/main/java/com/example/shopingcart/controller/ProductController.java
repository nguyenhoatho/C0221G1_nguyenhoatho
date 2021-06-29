package com.example.shopingcart.controller;

import com.example.shopingcart.model.entity.Cart;
import com.example.shopingcart.model.entity.Product;
import com.example.shopingcart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/")
    public ModelAndView showShop(@ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listProduct", productService.findAll());
        modelAndView.addObject("size",cart.getSize());
        return modelAndView;
    }

    @GetMapping("/product/view")
    public String viewProduct(@RequestParam Integer id,
                              Model model,
                              @SessionAttribute("cart") Cart cart){
        model.addAttribute("product", this.productService.findById(id));
        model.addAttribute("size", cart.getSize());
        return "product/view";
    }

}