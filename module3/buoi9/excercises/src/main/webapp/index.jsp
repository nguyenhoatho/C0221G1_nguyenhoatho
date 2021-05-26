<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/5/2021
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="ProductDiscountCalculator" method="post">
    <label>Mô tả của sản phẩm</label><br>
    <input type="text" name="productDescription" value=""><br>
    <label >Giá niêm yết của sản phẩm</label><br>
    <input type="number"  name="listPrice"><br><br>
    <label > Tỷ lệ chiết khấu (phần trăm)</label><br>
    <input type="number"  name="discountPercent"><br><br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
