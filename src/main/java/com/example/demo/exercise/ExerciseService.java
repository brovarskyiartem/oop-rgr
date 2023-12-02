package com.example.demo.exercise;

import com.example.demo.User.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseService {
    private static final String data = "exercisedata.txt";
    public static void saveExercises(String exerciseString) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(data, true))) {
            writer.write(exerciseString);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Exercise> findExerciseByLogin(String login) {
        List<Exercise> exercises = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] exerciseData = line.split(";");
                if (exerciseData.length == 5 && exerciseData[0].equals(login)) {
                    Exercise exercise;
                    String type = exerciseData[1];
                    switch (type) {
                        case "running" ->
                                exercise =new running(exerciseData[0], Integer.parseInt(exerciseData[2]), Integer.parseInt(exerciseData[3]), Integer.parseInt(exerciseData[4]),"outdore");
                        case "cycling" ->
                                exercise = new cycling(exerciseData[0], Integer.parseInt(exerciseData[2]), Integer.parseInt(exerciseData[3]), Integer.parseInt(exerciseData[4]),10);
                        case "swimming" ->
                                exercise = new swimming(exerciseData[0], Integer.parseInt(exerciseData[2]), Integer.parseInt(exerciseData[3]), Integer.parseInt(exerciseData[4]), 10);
                        default -> throw new IllegalStateException("Unexpected value: " + type);
                    }
                    exercises.add(exercise);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exercises;
    }

}
