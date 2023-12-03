package com.example.demo.exercise;

import java.time.LocalDateTime;

public class swimming extends Exercise{
    private int distance;
    private int calories;

    public swimming(){
    }

    public swimming(String login, int hours, int minutes, int seconds, int weight, int distance,int calories) {
        super("swimming", login, hours, minutes, seconds, weight);
        this.distance = distance;
        this.calories = calculateCalories(hours, minutes, seconds, distance, weight);
    }

    public swimming(String login, int hours, int minutes, int seconds, int distance,  int weight,int calories, LocalDateTime addingTime) {
        super("swimming", login, hours, minutes, seconds, weight, calories, addingTime);
        this.distance = distance;
        this.calories = calculateCalories(hours, minutes, seconds, distance, weight);
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public swimming(String login, int hours, int minutes, int seconds, int weight,int distance ) {
        super("swimming",login,  hours, minutes, seconds, weight);
        this.setCalories(calories);
        this.setDistance(distance);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
    public static int calculateCalories(int hours, int minutes, int seconds, int distance, int weight) {
        double caloriesPerMinute = 12.0;
        double intensityFactor = 1.2;
        int totalMinutes = hours * 60 + minutes + seconds / 60;
        double totalCalories = totalMinutes * caloriesPerMinute * intensityFactor*weight/100;
        double distanceCalories = distance * 0.1;
        totalCalories += distanceCalories;
        return (int) totalCalories;
    }

}
