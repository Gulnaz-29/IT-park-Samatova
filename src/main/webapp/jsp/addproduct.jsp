<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.04.2025
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= "ADD PRODUCT" %></h1>
<form action="/products/add" method="post">

    <label for="value1">Наименование:</label>
    <input type="text" id="value1" name="name" required>

    <label for="value2">Цена:</label>
    <input type="number" id="value2" name ="price" required>

    <label for="value3">Количество:</label>
    <input type="number" id="value3" name="quantity" required>

    <button type="submit">Добавить продукт</button>

</form>
</body>
</html>
