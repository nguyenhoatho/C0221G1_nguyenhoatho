<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/27/2021
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <style>
        th{
            width: 100px;
        }
    </style>
</head>
<body>
<h1>Product Search</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table border="1">
    <tr>
        <th>Name </th>
        <th>dateOfManufacture </th>
        <th>expiryDate </th>
        <th>origin</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.dateOfManufacture}</td>
            <td>${product.expiryDate}</td>
            <td>${product.origin}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
