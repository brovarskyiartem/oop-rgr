package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Fitnes")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/Fitnes")
    public User createUser(@RequestBody User user) {
        return UserService.saveUser(user);
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return UserService.getUsers();
    }
    @PostMapping
    public void RegisterNewUser(@RequestBody User user) throws IOException {
        UserService.addNewUser(user);
    }
}