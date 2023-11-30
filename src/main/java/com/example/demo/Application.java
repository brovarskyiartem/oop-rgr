package com.example.demo;

import com.example.demo.User.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableJpaRepositories(basePackages = "com.example.demo")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


