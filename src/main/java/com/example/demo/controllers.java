package com.example.demo;
import com.example.demo.User.User;
import com.example.demo.User.UserService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

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
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            UserService.registerUser(user);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
