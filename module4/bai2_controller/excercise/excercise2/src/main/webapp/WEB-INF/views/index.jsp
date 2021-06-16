<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/6/2021
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body>
  <form action="/submit" method="post">
    <p>so thu nhat</p>
    <input name="number1" type="text">
    <p>so thu hai</p>
    <input name="number2"type="text">
    <button type="submit" class="btn btn-primary" name="calculation" value="+">+</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="-">-</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="*">*</button>
    <button type="submit" class="btn btn-primary" name="calculation" value="/">/</button>
  </form>
  </body>
</html>
