<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/6/2021
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>translate</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form action="/translate" method="post">
    <p>nhap tu tieng anh</p>
    <input type="text" name="word">
    <button type="submit"  class="btn btn-primary">Submit</button>
</form>
</body>
</html>
