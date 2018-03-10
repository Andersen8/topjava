package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Андрей on 04.03.2018.
 */
public interface InterfaceMeal {
    List<MealWithExceed> getMealWithExceeds();
    void addMeals(LocalDateTime ldt, String des, String cal);
    List loopBackConvertation(List<MealWithExceed> mealWithExceeds);
    void setMealWithExceeds(List<MealWithExceed> mealWithExceeds);
    List<Meal> getMeals();
    void setMeals(List<Meal> meals);
}
