package com.example.demo.exercise;

import java.time.LocalDateTime;

public class cycling extends Exercise {
    private int distance;
    private int calories;

    public cycling(String login, int hours, int minutes, int seconds,int distance, int weight ,int calories) {
        super("cycling", login, hours, minutes, seconds, weight);
        this.distance = distance;
        this.calories = calculateCalories(hours, minutes, seconds, distance, weight);
    }
    public cycling(String login, int hours, int minutes, int seconds, int distance,int weight) {
        super("cycling",login, hours, minutes, seconds,weight);
        this.calories = calculateCalories(hours, minutes, seconds, distance, weight);
        this.distance = distance;
    }
    public cycling(String login, int hours, int minutes, int seconds, int weight,int distance, int calories, LocalDateTime addingTime) {
        super("cycling", login, hours, minutes, seconds, weight, calories, addingTime);
        this.setCalories(calories);
        this.setDistance(distance);
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public static int calculateCalories(int hours, int minutes, int seconds, int distance, int weight) {
        double caloriesPerMinute = 12.0;
        double intensityFactor = 0.8;
        int totalMinutes = hours * 60 + minutes + seconds / 60;
        double totalCalories = totalMinutes * caloriesPerMinute * intensityFactor*weight/100;
        double distanceCalories = distance * 0.1;
        totalCalories += distanceCalories;
        return (int) totalCalories;
    }
}
