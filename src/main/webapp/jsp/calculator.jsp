<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - calculator</title>
</head>
<body>
<h1><%= "Calculator" %></h1>
<form action="/calculator" method="get">

    <label for="value1">Первое значение:</label>
    <input type="text" id="value1" name="value1" required>

    <label for="value2">Второе значение:</label>
    <input type="text" id="value2" name="value2" required>

    <button type="submit" formaction="/calculator/sum" formmethod="GET">Посчитать сумму</button>
    <button type="submit" formaction="/calculator/minus" formmethod="GET">Посчитать вычитание</button>
    <button type="submit" formaction="/calculator/mult" formmethod="GET">Посчитать умножение</button>
    <button type="submit" formaction="/calculator/div" formmethod="GET">Посчитать деление</button>
</form>

</body>
</html>