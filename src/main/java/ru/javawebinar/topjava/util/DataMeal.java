package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 03.03.2018.
 */
public class DataMeal implements InterfaceMeal{

    private static DataMeal dataMeal = null;
    private static List<MealWithExceed> mealWithExceeds;
    private List<Meal> meals;

    private DataMeal() {
        meals = new ArrayList<Meal>();
        meals.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        meals.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        meals.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        meals.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        meals.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        meals.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));

//        mealWithExceeds = MealsUtil.getFilteredWithExceeded(meals, LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
    }

    public static DataMeal getInstance(){
        if (dataMeal == null){
            return dataMeal = new DataMeal();
        }else return dataMeal;
    }

    public List<MealWithExceed> getMealWithExceeds() {
        if(meals.size() < meals.get(0).getId()){
            for(int i=0; i<meals.size(); i++){
                meals.get(i).setId(i+1);
            }
        }
        mealWithExceeds = MealsUtil.getFilteredWithExceeded(meals, LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
        return mealWithExceeds;
    }

    public void setMealWithExceeds(List<MealWithExceed> mealWithExceeds) {
        this.mealWithExceeds = null;
        this.mealWithExceeds = mealWithExceeds;
    }

    public void addMeals(LocalDateTime ldt, String des, String cal){
        meals.add(new Meal(ldt, des, Integer.parseInt(cal)));
    }
    public List loopBackConvertation(List<MealWithExceed> mealWithExceeds){
        meals = null;
        meals = new ArrayList<Meal>();
        for (MealWithExceed mwe: mealWithExceeds){
            meals.add(new Meal(mwe.getDateTime(), mwe.getDescription(), mwe.getCalories()));
        }
        return null;
    }
    public void updateMeal(Integer calor, Integer ch){
        for(MealWithExceed mwe: mealWithExceeds){

        }
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
