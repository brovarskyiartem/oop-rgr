package com.example.demo.exercise;

public class Exercise {
    private String login;
    private String type;
    private int hours;
    private int minutes;
    private int seconds;
    private  int weight;
    private  int calories;
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
