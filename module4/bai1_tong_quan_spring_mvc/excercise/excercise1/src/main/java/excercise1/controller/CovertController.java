package excercise1.controller;

import excercise1.service.ConvertVnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CovertController {
 @Autowired
    private ConvertVnd convertService;
 @RequestMapping("")
 public String index(){
     return "index";
 }
 @PostMapping(value = {"/result"})
    public String result(@RequestParam String usd , Model model){
     int usd1=Integer.parseInt(usd);
     model.addAttribute("convertResult" ,convertService.convert(usd1));
     return "result";
 }


}
