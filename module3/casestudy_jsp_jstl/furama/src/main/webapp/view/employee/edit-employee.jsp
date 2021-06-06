<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/30/2021
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Furama Resort</title>
    <script src="../../lib/bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/css/bootstrap.css">
    <script src="../../lib/bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>
    <style>
        img {
            width: 20%;
            height: 80%;
        }

        .container-fluid .row {
            height: 10%;
        }

        input {
            width: 85%;
        }
    </style>
</head>
<body>
<jsp:include page="../../view/furama/furama-header.jsp"></jsp:include>
<div class="container">
    <form method="post">
        <div class=" row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8 bg-info">
                <div class="row p-3 bg-light">
                    <div class="col-lg-12 text-center">
                        <h1>Edit Employee</h1>
                        <c:if test="${message=='Edit successful'}">
                            <p class="text-success">${message}</p>
                        </c:if>
                        <c:if test="${message=='Edit unsuccessful'}">
                            <p class="text-danger">${message}</p>
                        </c:if>
                    </div>
                </div>
                <div class="row bg-light">
                    <div class="col-lg-12 w-100 p-0 m-0">
                        <a class="btn btn-success" href="/employee"> < Back to List</a>
                    </div>
                </div>
                <div class="row p-2 pt-5">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Name</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="employeeName" value="${employee.employeeName}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Birthday</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="date" name="employeeBirthday" value="${employee.employeeBirthday}">
                    </div>
                </div>

                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee ID Card</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="employeeIDCard" value="${employee.employeeIDCard}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Salary</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="employeeSalary" value="${employee.employeeSalary}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Phone</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="employeePhone" value="${employee.employeePhone}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Email</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="employeeEmail" value="${employee.employeeEmail}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Address</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="employeeAddress" value="${employee.employeeAddress}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Position ID</label>
                    </div>
                    <div class="col-lg-8">
                        <select class="form-select w-auto" aria-label="Default select example" name="positionID">
                            <c:forEach items="${positionList}" var="position">
                                <option value="${position.positionID}" ${position.positionID==employee.position.positionID?"selected":""}>${position.positionName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Education ID</label>
                    </div>
                    <div class="col-lg-8">
                        <select class="form-select w-auto" aria-label="Default select example" name="educationDegreeID">
                            <c:forEach items="${educationDegreeList}" var="educationDegree">
                                <option value="${educationDegree.educationDegreeID}" ${educationDegree.educationDegreeID==employee.educationDegree.educationDegreeID?"selected":""}>${educationDegree.educationDegreeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Division ID</label>
                    </div>
                    <div class="col-lg-8">
                        <select class="form-select w-auto" aria-label="Default select example" name="divisionID">
                            <c:forEach items="${divisionList}" var="division">
                                <option value="${division.divisionID}" ${division.divisionID==employee.division.divisionID?"selected":""}>${division.divisionName}</option>
                            </c:forEach>
                        </select></div>
                </div>
                <div class="row p-2 align-items-center">
                    <div class="col-lg-4 col-md-4 col-sm-4 "></div>
                    <div class="col-lg-4 col-md-4 col-sm-4 ">
                        <input class="btn btn-success" type="submit" id="submit" value="Edit Employee"
                               style="width: 200px">
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xl-4"></div>

                </div>
            </div>
            <div class="col-lg-2"></div>

        </div>
    </form>
</div>
<jsp:include page="../../view/furama/furama-footer.jsp"></jsp:include>
</body>
</html>



