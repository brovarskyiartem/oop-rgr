package com.example.demo.User;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@Service
public class UserService {
    public static List<User> getUsers(){
        return List.of(
                new User("Hewww","Hewww@gmail.com","Hewww@gmail.com"));}
    public User saveUser(User user) {
        String filePath = "user_data.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            // Зберегти дані користувача у файл
            writer.println("Login: " + user.getLogin());
            writer.println("Password: " + user.getLogin());
            writer.println("Email: " + user.getEmail());
            writer.println("Id: " + user.getId());
            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}

