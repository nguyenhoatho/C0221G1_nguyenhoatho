<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2021
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/product?action=create">Create new Product ||   </a>
    <a href="/product?action=search" style="color: red">Search  Product</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Manufacturers</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${productList}' var="product">
        <tr>
            <td>${product.id}</td>
            <td><a href="/product?action=view&id=${product.id}">${product.name}</a></td>
            <td>${product.dateOfManufacture}</td>
            <td>${product.expiryDate}</td>
            <td>${product.origin}</td>
            <td><a href="/product?action=edit&id=${product.id}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>