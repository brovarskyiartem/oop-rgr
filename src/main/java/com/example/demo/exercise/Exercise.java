package com.example.demo.exercise;

import lombok.Getter;

import java.time.LocalDateTime;

public class Exercise {
    private String login;
    private String type;
    private int hours;
    private int minutes;
    private int seconds;
    private  int weight;
    private  int calories;
    private LocalDateTime addingTime;
    public Exercise() {
    }

    public Exercise(String login, String type, int hours, int minutes, int seconds, int weight, int calories) {
        this.login = login;
        this.type = type;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.weight = weight;
        this.calories = calories;
        this.addingTime = LocalDateTime.now();
    }

    public Exercise(String Type,String login, int hours, int minutes, int seconds, int weight, int calories, LocalDateTime addingTime) {
        this.type = Type;
        this.login = login;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.weight = weight;
        this.calories = calories;
        this.addingTime = addingTime;
    }

    public void setAddingTime(LocalDateTime addingTime) {
        this.addingTime = addingTime;
    }
    public int getAddingYear() {
        return addingTime.getYear();
    }

    public int getAddingMonth() {
        return addingTime.getMonthValue();
    }

    public int getAddingDay() {
        return addingTime.getDayOfMonth();
    }
    public LocalDateTime getAddingTime() {
        return addingTime;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public Exercise(String type, String login , int hours, int minutes, int seconds, int weight) {
        this.login = login;
        this.type = type;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.weight = weight;
    }

    public String getLogin() {
        return login;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
