package com.example.demo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // Додайте додаткові методи, якщо потрібно
}
