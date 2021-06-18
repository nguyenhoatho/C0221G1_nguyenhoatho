package excercise.controller;

import excercise.model.Product;
import excercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"","/product"})
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("")
    public String index(Model model) {
        List<Product> customerList = productService.findAll();
        model.addAttribute("product", customerList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
            model.addAttribute("product", new Product());
            return "/create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setIdProduct((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getIdProduct(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getIdProduct());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @PostMapping("/product/search")
    public String searchProduct(@RequestParam String searchProduct, Model model) {
        List<Product> productList = productService.search(searchProduct);
        model.addAttribute("product", productList);
        return "index";
    }




}
