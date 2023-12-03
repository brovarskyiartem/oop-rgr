package com.example.demo.exercise;

import java.time.LocalDateTime;

public class running  extends Exercise{
    private String terra;
    private int calories;

    public running() {
    }
    public running(String login, int hours, int minutes, int seconds, int weight, String terra,int calories) {
        super("running", login, hours, minutes, seconds, weight,calories);
        this.terra = terra;
    }

    public running(String login, int hours, int minutes, int seconds, int weight, int calories, String terra, LocalDateTime addingTime) {
        super( "running",login, hours, minutes, seconds, weight, calories, addingTime);
        this.terra = terra;
        this.calories = calculateCalories(hours, minutes, seconds, terra, weight);
    }

    public running(String login, int hours, int minutes, int seconds, String terra, int weight) {
        super("running",login,  hours, minutes, seconds,weight);
        this.terra = terra;
        this.calories = calculateCalories(hours, minutes, seconds, terra, weight);
    }

    public String getTerrain() {
        return terra;
    }
    public void setTerrain(String terrain) {
            this.terra = terrain;
        }
    public static int calculateCalories(int hours, int minutes, int seconds, String terra, int weight) {
        double caloriesPerMinute = 10.0;
        double intensityFactor = terrafactor(terra);
        int totalMinutes = hours * 60 + minutes + seconds / 60;
        double totalCalories = totalMinutes * caloriesPerMinute * intensityFactor* weight/100;
        return (int) totalCalories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    private static double terrafactor(String terra) {
        switch (terra) {
            case "outdoor":
                return 1.2;
            case "treadmill":
                return 1.0;
            default:
                return 1.0;
        }
    }
    }
