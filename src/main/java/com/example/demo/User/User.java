package com.example.demo.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
    private String login;
    private String password;
    private  String email;
    @Id
    private long id;
    public User(){
    }
    public User(long id, String login, String password, String email ) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;

    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
