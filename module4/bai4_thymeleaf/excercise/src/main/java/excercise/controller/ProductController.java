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
    public String indexShow(Model model) {
        List<Product> customerList = productService.findAll();
        model.addAttribute("product", customerList);
        return "/index";
    }
    @GetMapping("/create")
    public String createShowForm(Model model) {
            model.addAttribute("product", new Product());
            return "/create";
    }
    @PostMapping("/save")
    public String saveProdduct(Product product) {
        product.setIdProduct((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String editShowForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String updateProduct(Product product) {
        productService.update(product.getIdProduct(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String deleteShowForm(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String deleteProduct(Product product, RedirectAttributes redirect) {
        productService.remove(product.getIdProduct());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String viewShowForm(@PathVariable int id, Model model) {
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
