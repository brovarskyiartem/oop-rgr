package com.example.demo.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String data = "user_data.txt";
    private static AtomicInteger userCounter = new AtomicInteger(0);
    public static User saveUser(User user) {
        user.setId(userCounter.incrementAndGet());
        try (PrintWriter writer = new PrintWriter(new FileWriter(data, true))) {
            writer.println(user.getId() + ";" + user.getLogin() + ";" + user.getPassword() + ";" + user.getEmail() + ";" + user.getFirstname() + ";" + user.getLastname()+ ";" + user.getWeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void registerUser(User user) throws IOException {
        if (UserRepository.isEmailExists(user.getEmail())) {
            throw new IllegalArgumentException("This email is already in use by another user");
        }
        if (UserRepository.isLoginExists(user.getLogin())) {
            throw new IllegalArgumentException("This login is already in use by another user");
        }
        if(user.getWeight()<=0){
            throw new IllegalArgumentException("Incorect weight");
        }
        saveUser(user);
    }
    public static boolean loginUser(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";");
                if (userData.length == 7) {
                    String storedLogin = userData[1];
                    String storedPassword = userData[2];
                    if (storedLogin.equals(login) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static User getUserByLogin(String login) {
        try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";");
                if (userData.length == 7 && userData[1].equals(login)) {
                    User user = new User();
                    user.setId(Integer.parseInt(userData[0]));
                    user.setLogin(userData[1]);
                    user.setPassword(userData[2]);
                    user.setEmail(userData[3]);
                    user.setFirstname(userData[4]);
                    user.setLastname(userData[5]);
                    user.setWeight(Integer.parseInt(userData[6]));
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

