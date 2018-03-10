package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.DataMeal;
import ru.javawebinar.topjava.util.InterfaceMeal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Андрей on 03.03.2018.
 */
public class DeleteServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        List<MealWithExceed> meallist = (List<MealWithExceed>) httpSession.getAttribute("meallist");
        String ids = req.getParameter("deleteById");
        List<MealWithExceed> mil = meallist.stream().filter(meal -> meal.getId() != Integer.parseInt(ids))
                .collect(toList());
        httpSession.setAttribute("meallist", mil);
        req.setAttribute("mealList", mil);
        InterfaceMeal dataMeal = DataMeal.getInstance();
        dataMeal.loopBackConvertation(mil);

        resp.sendRedirect("/topjava");
//        req.getRequestDispatcher("/meal.jsp");
    }


}
