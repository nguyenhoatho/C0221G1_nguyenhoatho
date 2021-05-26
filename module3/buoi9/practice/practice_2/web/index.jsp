<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/26/2021
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        .login {
            height: 180px;
            width: 300px;
            margin: 0;
            padding: 10px;
            border: 1px solid;
        }

        .login input {
            padding: 5px;
            margin: 5px;
        }
    </style>
</head>
<body>
<div class="login">
    <form method="post" action="/login">
        <h2>Login</h2>
        <input type="text" name="username" size="30" placeholder="username"/>
        <input type="password" name="password" size="30" placeholder="password"/>
        <input type="submit" value="Sign in"/>
    </form>
</div>
</body>
</html>
