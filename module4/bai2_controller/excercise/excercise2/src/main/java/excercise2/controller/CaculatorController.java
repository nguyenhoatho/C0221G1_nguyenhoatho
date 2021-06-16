package excercise2.controller;

import excercise2.model.ICaculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    ICaculator caculatorService;
    @GetMapping("")
    public String displayIndex(){
        return "index";
    }
    @PostMapping("/submit")
    public String result(@RequestParam String number1, @RequestParam String number2, @RequestParam String calculation, Model model){
        int numberA=Integer.parseInt(number1);
        int numberB=Integer.parseInt(number2);
        int result=0;

        if (calculation.equals("*")){
             result=caculatorService.multi(numberA,numberB);
        }
        if (calculation.equals("-")){
            result=caculatorService.subtraction(numberA,numberB);

        }
        if (calculation.equals("+")){
             result=caculatorService.sum(numberA,numberB);


        }
        if (calculation.equals("/")){
             result=caculatorService.div(numberA,numberB);
        }
        model.addAttribute("result",result);
        return "result";

    }

}

