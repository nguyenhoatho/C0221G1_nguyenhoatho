package excercise.controller;

import excercise.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {

    @GetMapping(value = {"","mail-box"})
    public String mailBox(Model model){
        model.addAttribute("mailBox",new MailBox());
        model.addAttribute("languageArray",new String[]{"English","Vietnamese","Japanese","Chinese"});
        model.addAttribute("pageSizeArray",new int[]{5,10,15,25,50,100});
        model.addAttribute("pageSizeArray",new int[]{5,10,15,25,50,100});
        return "mail-box";
    }

    @PostMapping(value = "saveMailBox")
    public String saveMailBox(@ModelAttribute("mailBox") MailBox mailBox, Model model){
        model.addAttribute("mailBox",mailBox);
        return "display";
    }
}
