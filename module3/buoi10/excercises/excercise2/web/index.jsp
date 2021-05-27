<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/27/2021
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        form{
            width: 400px;
            height: auto;
            font-size: 20px;
            padding: 10px;
        }
    </style>
</head>
<body>
<h1>Simple model</h1>
<form method="post" action="/calculate" >
    <fieldset>
        <legend>Calculator</legend>
    <label>First operand: </label>
    <input type="text" name="firstOperand"><br>
    <label>Operand: </label>
    <select name="operand">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br>
    <label>First operand: </label>
    <input type="text" name="secondOperand"><br>
    <input type="submit" id="submit" value="Calculate">
    </fieldset>

</form>
</body>
</html>
