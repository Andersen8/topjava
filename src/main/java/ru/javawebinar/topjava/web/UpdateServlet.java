package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.InterTool;
import ru.javawebinar.topjava.model.MealTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

/**
 * Created by Андрей on 07.03.2018.
 */
public class UpdateServlet extends HttpServlet {
    static int i;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        i = Integer.parseInt(req.getParameter("editbyid"));
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desc = req.getParameter("udesc");
        int calo = Integer.parseInt(req.getParameter("ucalo"));
        String str = req.getParameter("datetime");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
        LocalDateTime ldt = LocalDateTime.parse(str, dtf);
        InterTool mt = MealTool.getMt();
        mt.getMealList().stream()
                .filter(meal -> meal.getId() == i)
                .collect(Collectors.toList()).get(0).setDesCal(ldt,desc, calo);
        resp.sendRedirect("/topjava");
    }
}
