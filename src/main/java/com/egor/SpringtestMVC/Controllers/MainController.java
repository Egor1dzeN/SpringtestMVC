package com.egor.SpringtestMVC.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("name","egor");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","О нас");
        return "aboutUS";
    }


}