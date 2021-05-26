<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/26/2021
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <form action="/convert" method="post">
      <h2>Currency Converter</h2>
      <label>Rate:</label><br>
      <input type="text"name="rate" placeholder="Rate" value="23000"><br>
      <label>USD:</label><br>
      <input type="text" name="usd" placeholder="USD" value="0"><br>
      <input type="submit" id="submit" value="Converter">
    </form>
  </div>
  </body>
</html>
