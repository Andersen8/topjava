package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.DataMeal;
import ru.javawebinar.topjava.util.InterfaceMeal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Андрей on 03.03.2018.
 */
public class UpdateServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);
    private String s;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String calorie = req.getParameter("calorie");
        InterfaceMeal interfaceMeal = DataMeal.getInstance();
        int ii = Integer.parseInt(s);
        for(Meal meal: interfaceMeal.getMeals()){
            if(meal.getId() == ii){
                meal.setCalories(Integer.parseInt(calorie));
            }
        }

        resp.sendRedirect("/topjava");
//        req.getRequestDispatcher("meal.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       s = req.getParameter("updateById");
//        resp.sendRedirect("/update");
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
}
