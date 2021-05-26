<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/5/2021
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>mô tả sản phẩm :<%=request.getAttribute("productDescription")
 %>
 </h1>
 <h1>giá sản phẩm :<%=request.getAttribute("listPrice") %> </h1>
<h1>tỷ lệ chiết khấu :<%=request.getAttribute("discountPercent")%></h1>
<h1>giá chiết khấu :<%=request.getAttribute("discountAmount")%></h1>
</body>
</html>
