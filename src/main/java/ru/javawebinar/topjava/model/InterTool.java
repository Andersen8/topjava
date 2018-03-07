package ru.javawebinar.topjava.model;

import java.util.List;

/**
 * Created by Андрей on 07.03.2018.
 */
public interface InterTool {
    List<MealWithExceed> resultList();
    List<Meal> getMealList();
    void setMealList(List<Meal> mealList);
}
