<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 07.03.2018
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Add new Meal</title>
</head>
<body>
        <h4><div align="center">
            <form method="post" action="/create">
                <p>Add date and time (yyyy-MM-dd HH-mm):<br><input type="text" name="dtime"/></p>
                <p>Add discription:<br><input type="text" name="desc"/></p>
                <p>Add calories:<br><input type="text" name="calo"/></p>
                <p><button type="submit">Submit</button></p>

            </form>
        </div></h4>
</body>
</html>
