package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.InterTool;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by Андрей on 07.03.2018.
 */
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("desc");
        int calories = Integer.parseInt(req.getParameter("calo"));
        String str = req.getParameter("dtime");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
        LocalDateTime ldt = LocalDateTime.parse(str,dtf);
        InterTool mt = MealTool.getMt();
        mt.getMealList().add(new Meal(ldt, description, calories));
        resp.sendRedirect("/topjava");
    }
}
