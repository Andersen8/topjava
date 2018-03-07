<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 02.03.2018
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Meals Table</title>
</head>
<body>
    <div align="center">
        <form method="get" action="/create"><input type="submit" class="button4" value="Add new Meal"></form>
        <%--<button type="submit">Create new Meal</button>--%>
        <table border="2" cellpadding="2" cellspacing="2">
                <tr>
                    <h3><th>ID</th></h3>
                    <h3><th>Date and Time</th></h3>
                    <h3><th>Description</th></h3>
                    <h3><th>Calories</th></h3>
                    <h3><th>Is norma</th></h3>
                    <h3><th>Edit</th></h3>
                    <h3><th>Delete</th></h3>
                </tr>
        <c:forEach var="meal" items="${sessionScope.get('mealList')}">
                <tr style="color: ${!meal.exceed ? '#097201' : '#ff0000'}">
                    <td>${meal.id}</td>
                    <td>${meal.dateTimeString}</td>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                    <td>${!meal.exceed}</td>
                    <td><form method="get" action="/update">
                        <input type="hidden" name="editbyid"   value="${meal.id}" />
                        <a href="/update?editbyid=${meal.id}" class="button14">Update</a>
                        <%--<button type="submit" name="editbyid" value="${meal.id}">Edit</button>--%>
                    </form> </td>
                    <td>
                        <form method="post" action="/delete">
                        <button type="submit" name="deletebyid" value="${meal.id}">Delete</button>
                    </form>
                    </td>
                </tr>
        </c:forEach>
        </table>
    </div>

</body>
</html>
