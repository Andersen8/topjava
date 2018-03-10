package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.DataMeal;
import ru.javawebinar.topjava.util.InterfaceMeal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Андрей on 03.03.2018.
 */
public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InterfaceMeal dm = DataMeal.getInstance();
        List list = dm.getMealWithExceeds();
        HttpSession hs = req.getSession();
        dm.loopBackConvertation(list);
        hs.setAttribute("meallist", list);
        log.debug("forward to meal jsp");
        req.getRequestDispatcher("meal.jsp").forward(req, resp);
    }
}
