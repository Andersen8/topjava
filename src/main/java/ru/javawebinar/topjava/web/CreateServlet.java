package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.DataMeal;
import ru.javawebinar.topjava.util.InterfaceMeal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Андрей on 03.03.2018.
 */
public class CreateServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String desc = req.getParameter("description");
        String calo = req.getParameter("calories");
        InterfaceMeal dm = DataMeal.getInstance();
        dm.addMeals(localDateTime, desc, calo);
//        req.getRequestDispatcher("meal.jsp").forward(req, resp);
        resp.sendRedirect("/topjava");
    }
}
