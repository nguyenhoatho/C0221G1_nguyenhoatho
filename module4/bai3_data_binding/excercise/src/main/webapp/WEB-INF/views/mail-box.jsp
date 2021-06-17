<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/6/2021
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="post" action="saveMailBox" modelAttribute="mailBox">
    <table>
        <tr>
            <td><form:label path="language">Languages: </form:label></td>
            <td><form:select path="language" items="${languageArray}"></form:select></td>
        </tr>
        <tr>
            <td><from:label path="pageSize">Page Size: </from:label></td>
            <td>Show <form:select path="pageSize" items="${pageSizeArray}"></form:select> email per page</td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spams Filter: </form:label></td>
            <td><form:checkbox path="spamFilter"></form:checkbox> enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td><button type="submit">Update</button></td>
            <td><button type="reset">Cancel</button> </td>
        </tr>
    </table>
</form:form>
</body>
</html>