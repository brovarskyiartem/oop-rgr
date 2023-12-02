package com.example.demo.exercise;

public class running  extends Exercise{
        private String terra;

    public running(String terra, int i, int parseInt, String part) {
        this.terra = terra;
    }

    public running(String login, int hours, int minutes, int seconds,String terra) {
        super("running",login,  hours, minutes, seconds);
        this.terra = terra;
    }

    public String getTerrain() {
            return terra;
        }

        public void setTerrain(String terrain) {
            this.terra = terrain;
        }
    }
