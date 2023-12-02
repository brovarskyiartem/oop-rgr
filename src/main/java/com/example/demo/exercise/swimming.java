package com.example.demo.exercise;

public class swimming extends Exercise{
    private int distance;

    public swimming(String part, int parseInt, int i, int distance) {
        this.distance = distance;
    }

    public swimming(String login, int hours, int minutes, int seconds, int distance) {
        super("swimming",login,  hours, minutes, seconds);
        this.distance = distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
