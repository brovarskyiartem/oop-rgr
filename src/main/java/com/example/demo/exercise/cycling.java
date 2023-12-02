package com.example.demo.exercise;

public class cycling extends Exercise {
    private long distance;

    public cycling(String login, int hours, int minutes, long distance) {
        this.distance = distance;
    }

    public cycling(String login, int hours, int minutes, int seconds, long distance) {
        super("cycling",login, hours, minutes, seconds);
        this.distance = distance;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

}
