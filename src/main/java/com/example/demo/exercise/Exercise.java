package com.example.demo.exercise;

public class Exercise {

    private String login;
    private String type;
    private int hours;
    private int minutes;
    private int seconds;

    public Exercise() {
    }

    public Exercise(String type, String login , int hours, int minutes, int seconds) {
        this.login = login;
        this.type = type;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getLogin() {
        return login;
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
    @Override
    public String toString() {
        return login + ";" + type + ";" + hours + ";" + minutes + ";" + seconds;
    }

}
