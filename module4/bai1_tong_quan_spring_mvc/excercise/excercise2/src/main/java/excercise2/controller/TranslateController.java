package excercise2.controller;

import excercise2.model.service.ITranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private ITranslate translateService;
    @RequestMapping("")
    public String translate(){
        return "translate";
    }
    @PostMapping("/translate")
    public String translateWord(@RequestParam String word, Model model){
        model.addAttribute("result",translateService.translate(word));
        return "result";

    }



}
