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
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table>
    <tr>
        <td>ID: </td>
        <td>${product.id}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>dateOfManufacture: </td>
        <td>${product.dateOfManufacture}</td>
    </tr>
    <tr>
        <td>expiryDate: </td>
        <td>${product.expiryDate}</td>
    </tr>
    <tr>
        <td>origin: </td>
        <td>${product.origin}</td>
    </tr>
</table>
</body>
