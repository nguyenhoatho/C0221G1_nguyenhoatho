package com.example.shopingcart.controller;

import com.example.shopingcart.model.entity.Cart;
import com.example.shopingcart.model.entity.Product;
import com.example.shopingcart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/cart")
    public String goToCart(Model model,
                           @ModelAttribute("cart") Cart cart) {
        model.addAttribute("listProduct", cart.getCart());
        model.addAttribute("total", cart.getTotal());
        return "cart/cart";
    }

    @PostMapping("/cart/remove")
    public String removeProductFromCart(@RequestParam Integer id,
                                        @SessionAttribute("cart") Cart cart,
                                        RedirectAttributes redirect) {
        Product product = this.productService.findById(id);
        cart.removeProduct(product);
        redirect.addFlashAttribute("message", "Remove Product " + product.getName() + " successfully!");
        return "redirect:/cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Integer id,
                            @RequestParam Integer amount,
                            Model model,
                            @SessionAttribute("cart") Cart cart) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        if (product != null) {
            cart.addToCart(product, amount);
            model.addAttribute("size", cart.getSize());
            model.addAttribute("message", "Add product" + product.getName() + "with amount :" + cart.getAmount(product) + " succcess full");
        }
        return "product/view";
    }

}
