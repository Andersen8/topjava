<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 03.03.2018
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals Table</title>
</head>
<body>
        <div align="center">
            <form action="/create" method="get">
                    <button type="submit" name="createById">Create a new Meal</button>
            </form>
            <table align="center" border="2" cellpadding="2" cellspacing="2">
                <tr>
                    <th>ID number</th>
                    <th>Date & Time</th>
                    <th>Description</th>
                    <th>Calories</th>
                    <th>Exceed</th>
                </tr>
                <c:forEach var="item" items="${meallist}">
                    <tr style="color: ${!item.exceed ? '#00ff00': '#ff0000'};">
                        <td>${item.id}</td>
                        <td>${item.dateTime}</td>
                        <td>${item.description}</td>
                        <td>${item.calories}</td>
                        <td>${!item.exceed}</td>
                        <form action="/delete" method="post">
                            <td>
                                <button type="submit" name="deleteById" value="${item.id}">Delete</button>
                            </td>
                        </form>

                        <form action="/update" method="get">
                            <td>
                                <button type="submit" name="updateById" value="${item.id}">Update</button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>

            </table>
        </div>
</body>
</html>
