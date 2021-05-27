<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/27/2021
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Danh sách khách hàng</h1>
    <table class="table table-bordered">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.birthday}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td class="text-center"><img src="${customer.image}" width="150px" height="100px"></td>
        </tr
        </c:forEach>
    </table>
</div>
</body>
</html>
