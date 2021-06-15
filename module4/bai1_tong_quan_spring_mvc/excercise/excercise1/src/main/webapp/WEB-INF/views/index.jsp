<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/6/2021
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body>
  <form action="/result" method="post"  >
    <div class="form-group">
      <label>usd</label>
      <input type="text" name="usd" placeholder="usd">
    </div>
    <button type="submit" name="convert" class="btn btn-primary">Submit</button>
  </form>
  </body>
</html>
