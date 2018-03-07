package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 02.03.2018.
 */
public  class MealTool implements InterTool{
    private  List<MealWithExceed> mealWithExceedList;
    private  List<Meal> mealList;
    private static MealTool mt = null;

    public static MealTool getMt(){
        if(mt == null){
            return mt = new MealTool();
        }else return mt;
    }
    private MealTool() {
        mealList = new ArrayList<Meal>();
        mealList.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        mealList.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        mealList.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        mealList.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        mealList.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        mealList.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    public List<MealWithExceed> resultList(){
        return mealWithExceedList = MealsUtil.getFilteredWithExceeded(mealList, LocalTime.of(0,0), LocalTime.of(23,0), 2000);
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }
}
