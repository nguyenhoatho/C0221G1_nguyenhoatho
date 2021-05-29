<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2021
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="dateOfManufacture" id="dateOfManufacture"></td>
            </tr>
            <tr>
                <td>Product Description: </td>
                <td><input type="text" name="expiryDate" id="expiryDate"></td>
            </tr>
            <tr>
                <td>Manufacturers: </td>
                <td><input type="text" name="origin" id="origin"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Products"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>