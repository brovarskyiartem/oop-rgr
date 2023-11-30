package com.example.demo;

import com.example.demo.User.User;
import com.example.demo.User.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableJpaRepositories(basePackages = "com.example.demo")
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		User user1 = new User("user1", "user1","User1@gmail.com");
		User user2 = new User("user2", "user2","User2@gmail.com");
		User user3 = new User("user1", "user1","User1@gmail.com");
		UserService.addNewUser(user1);
		UserService.addNewUser(user2);
		UserService.addNewUser(user3);
	}
}


