package com.example.demo;
import com.example.demo.User.User;
import com.example.demo.User.UserService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class controllers {
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("title","Головна сторінка");
        return "main";
    }
    @GetMapping("/login")
    public String showloginForm(Model model){
        model.addAttribute("login", "login");
        return "login";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String login, @RequestParam String password, Model model) throws IllegalArgumentException {
        if(UserService.loginUser(login, password)){
            return "redirect:/dashboard?login=" + login;
        } else {
            model.addAttribute("error", "Invalid login or password");
            return "login";
        }
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
    @GetMapping("/dashboard")
    public String showDashboard(@RequestParam String login, Model model) {
        User user = UserService.getUserByLogin(login);

        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            model.addAttribute("error", "User not found");
            return "login";
        }
    }



}
