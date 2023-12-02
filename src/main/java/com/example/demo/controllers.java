package com.example.demo;
import com.example.demo.User.User;
import com.example.demo.User.UserService;
import com.example.demo.exercise.Exercise;
import com.example.demo.exercise.ExerciseService;
import com.example.demo.exercise.cycling;
import com.example.demo.exercise.running;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.example.demo.exercise.ExerciseService.findExerciseByLogin;

@Controller
public class controllers {
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Головна сторінка");
        return "main";
    }

    @GetMapping("/login")
    public String showloginForm(Model model) {
        model.addAttribute("login", "login");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String login, @RequestParam String password, Model model, HttpSession session) throws IllegalArgumentException {
        if (UserService.loginUser(login, password)) {
            session.setAttribute("loggedInUser", login);
            return "redirect:/dashboard";
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
    public String registerUser(@ModelAttribute User user, Model model, HttpSession session) {
        try {
            UserService.registerUser(user);
            session.setAttribute("loggedInUser", user.getLogin());
            return "redirect:/dashboard";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
        String login = (String) session.getAttribute("loggedInUser");
        if (login != null) {
            User user = UserService.getUserByLogin(login);
            if (user != null) {
                List<Exercise> exercises = findExerciseByLogin(login);
                model.addAttribute("user", user);
                model.addAttribute("exercises", exercises);
                return "dashboard";
            } else {
                model.addAttribute("error", "User not found");
                return "login";
            }
        } else {
            model.addAttribute("error", "Login parameter is missing");
            return "login";
        }
    }


    @GetMapping("/addExercise")
    public String showAddExercise(Model model, HttpSession session) {
        String login = (String) session.getAttribute("loggedInUser");
        if (login == null) {
            return "error";
        }
        model.addAttribute("login", login);
        model.addAttribute("exercise", new Exercise());
        return "addExercise";
    }

    @PostMapping("/addExercise")
    public String addExercise(@RequestParam String exerciseType,
                              @RequestParam int hours,
                              @RequestParam int minutes,
                              @RequestParam int seconds,
                              Model model,
                              HttpSession session) {
        String login = (String) session.getAttribute("loggedInUser");
        if (login != null) {
            Exercise exercise = new Exercise(exerciseType, login, hours, minutes, seconds);
            ExerciseService.saveExercises(String.valueOf(exercise));
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "User not logged in");
            return "login";
        }
    }
}

