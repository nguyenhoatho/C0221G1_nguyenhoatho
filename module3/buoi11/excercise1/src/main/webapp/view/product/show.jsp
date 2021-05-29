<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2021
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <th>Price </th>
        <th>Product Description </th>
        <th>Manufacture</th>
    </tr>
    <c:forEach var="product" items="${productList}">
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

