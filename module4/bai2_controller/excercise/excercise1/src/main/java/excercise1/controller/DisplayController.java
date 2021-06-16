package excercise1.controller;

import excercise1.model.service.ISpice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DisplayController {
    @Autowired
    ISpice iSpice;
    @GetMapping("")
    public String getIndex(Model model){
        model.addAttribute("spice",iSpice.spice());
        return "index";
    }
    @PostMapping("/submit")
    public String displaySpice(@RequestParam String spice,Model model){
        List<String> stringList=new ArrayList<>();
        stringList.add(spice);
        model.addAttribute("result",stringList);
        return "result";
    }
}
