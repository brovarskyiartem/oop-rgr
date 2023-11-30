package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllers {
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("title","Головна сторінка");
        return "main";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("login", "Логін");
        return "login";
    }
}
