package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {
    private static UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static List<User> getUsers(){
        return (List<User>) userRepository.findAll();}
    private static AtomicInteger userCounter = new AtomicInteger(0);

    public static User saveUser(User user) {
        user.setId(userCounter.incrementAndGet());
        String filePath = "user_data.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(user.getId() + ";" + user.getLogin() + ";" + user.getPassword() + ";" + user.getEmail()+";"+user.getFirstname()+";"+user.getLastname() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void addNewUser(User user) throws IOException {
        Boolean isEmailExists = UserRepository.isEmailExists(user.getEmail());
        Boolean isLoginExists = UserRepository.isLoginExists(user.getLogin());
        if (isEmailExists) {
            throw new IllegalArgumentException("This email is already in use by another user");
        }
        if (isLoginExists) {
            throw new IllegalArgumentException("This login is already in use by another user");
        }
        saveUser(user);
    }
}

