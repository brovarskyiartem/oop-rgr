package com.example.demo.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public interface UserRepository {
    public static boolean isEmailExists(String email) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
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
}
