<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 03.03.2018
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new meal</title>
</head>
<body>
    <div align="center">
        <form method="post" action="/create">
        <h2>Select Description:<select name="description">
            <option>Breakfast</option>
            <option>Dinner</option>
            <option>Meal</option>
        </select></h2>
        <h2>Enter Calories:<input type="text" name="calories"/></h2><br>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
