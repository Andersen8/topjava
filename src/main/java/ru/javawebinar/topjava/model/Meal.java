package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Meal {
    private static AtomicInteger ai = new AtomicInteger(1);
    private int id;
    private  LocalDateTime dateTime;

    private  String description;

    private  int calories;

    public Meal(LocalDateTime dateTime, String description, int calories) {
        id = ai.getAndIncrement();
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public static AtomicInteger getAi() {
        return ai;
    }

    public static void setAi(AtomicInteger ai) {
        Meal.ai = ai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setDesCal(LocalDateTime ltd, String des, int cal){
        this.dateTime = ltd;
        this.description = des;
        this.calories = cal;
    }
}
