package com.example.demo.User;
import org.springframework.data.repository.CrudRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    String filePath = "user_data.txt";
    public static boolean isEmailExists(String email) throws IOException {
        String filePath = "user_data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length < 4) {
                    continue;
                }
                if (fields[3].equals(email)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean isLoginExists(String login) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length < 4) {
                    continue;
                }
                if (fields[1].equals(login)) {
                    return true;
                }
            }
        }

        return false;
    }

    Optional<User> findByLogin(String login);
}
