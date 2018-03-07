package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.InterTool;
import ru.javawebinar.topjava.model.MealTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by Андрей on 07.03.2018.
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = Integer.parseInt(req.getParameter("deletebyid"));
        InterTool mt = MealTool.getMt();
        mt.setMealList(
                mt.getMealList().stream()
                .filter(meal -> meal.getId() != i)
                .collect(Collectors.toList())
        );
        resp.sendRedirect("/topjava");
    }

}
