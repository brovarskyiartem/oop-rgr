package com.example.demo.exercise;

public class cycling extends Exercise {
    private static long distance;
    private static int calories;

    public cycling() {
    }
    public cycling(String login, int hours, int minutes, int seconds, int weight, int distance,int calories) {
        super("cycling", login, hours, minutes, seconds, weight);
        this.setCalories(calories);
        this.setDistance(distance);
    }
    public cycling(String login, int hours, int minutes, int seconds, int distance,int weight) {
        super("cycling",login, hours, minutes, seconds,weight);
        this.calories = calculateCalories(hours, minutes, seconds, distance, weight);
        this.distance = distance;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public static long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
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
