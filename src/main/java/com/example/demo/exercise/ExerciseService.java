package com.example.demo.exercise;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class ExerciseService {
    private static final String data = "exercisedata.txt";
    public static void saveExercises(Exercise exercise) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(data, true))) {
            writer.print(exercise.getLogin() + ";" + exercise.getType() + ";" + exercise.getHours() + ";" + exercise.getMinutes() + ";" + exercise.getSeconds());

            if (exercise instanceof running) {
                running Running = (running) exercise;
                writer.print(";" + Running.getTerrain() + ";" + exercise.getWeight() + ";" + exercise.getCalories() + ";" + exercise.getAddingTime() + "\n");
            } else if (exercise instanceof swimming) {
                swimming Swimming = (swimming) exercise;
                writer.print(";" + Swimming.getDistance() + ";" + exercise.getWeight() + ";" + exercise.getCalories() + ";" + exercise.getAddingTime() + "\n");
            } else if (exercise instanceof cycling) {
                cycling Cycling = (cycling) exercise;
                writer.print(";" + Cycling.getDistance() + ";" + exercise.getWeight() + ";" + exercise.getCalories() + ";" + exercise.getAddingTime() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Exercise> findExercisesByLogin(String login) {
        List<Exercise> exercises = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] exerciseData = line.split(";");
                if (exerciseData[0].equals(login)) {
                    Exercise exercise;
                    String type = exerciseData[1];
                    switch (type) {
                        case "running" -> {
                            exercise = new running(exerciseData[0], Integer.parseInt(exerciseData[2]), Integer.parseInt(exerciseData[3]), Integer.parseInt(exerciseData[4]), Integer.parseInt(exerciseData[6]), Integer.parseInt(exerciseData[7]), exerciseData[5], LocalDateTime.parse(exerciseData[8], DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                            );}
                        case "cycling" -> {
                            exercise = new cycling(exerciseData[0], Integer.parseInt(exerciseData[2]), Integer.parseInt(exerciseData[3]), Integer.parseInt(exerciseData[4]), Integer.parseInt(exerciseData[5]),Integer.parseInt(exerciseData[6]),Integer.parseInt(exerciseData[7]), LocalDateTime.parse(exerciseData[8], DateTimeFormatter.ISO_LOCAL_DATE_TIME));}
                        case "swimming" -> {
                            exercise = new swimming(exerciseData[0], Integer.parseInt(exerciseData[2]), Integer.parseInt(exerciseData[3]), Integer.parseInt(exerciseData[4]), Integer.parseInt(exerciseData[5]),Integer.parseInt(exerciseData[6]),Integer.parseInt(exerciseData[7]),LocalDateTime.parse(exerciseData[8], DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                        }
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