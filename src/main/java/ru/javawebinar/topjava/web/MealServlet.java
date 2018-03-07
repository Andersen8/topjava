package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.InterTool;
import ru.javawebinar.topjava.model.MealTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Андрей on 02.03.2018.
 */
public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InterTool mt = MealTool.getMt();
        List lst = mt.resultList();
        req.getSession().setAttribute("mealList", lst);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);

    }
}
