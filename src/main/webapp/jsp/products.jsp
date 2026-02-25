<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.04.2025
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<html>
<head>
    <title>Title</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h1><%= "PRODUCTS" %></h1>

<div class="button-group">
    <form action="/products/add" method="get" style="display: inline;">
        <button type="submit">ДОБАВИТЬ ПРОДУКТ</button>
    </form>
    <form action="/products/sort" method="get" style="display: inline;">
        <button type="submit">СОРТИРОВАТЬ ПО АЛФАВИТУ</button>
    </form>
</div>

<!-- Таблица для вывода продуктов -->
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Цена</th>
        <th>Количество</th>
    </tr>

    <!-- Цикл по списку продуктов -->
    <c:forEach var="product" items="${products.products}">
    <tr>
            <td>${product.id_product}</td>
            <td>${product.name}</td>
            <td>${product.price} ₽</td>
            <td>${product.quantity}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
