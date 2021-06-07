<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 6/7/2021
  Time: 9:55 AM
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
<div class="container mb-0">
    <form method="post" action="/contract?action=edit">
        <div class=" row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8 bg-info">
                <div class="row p-3 bg-light">
                    <div class="col-lg-12 text-center">
                        <h1>Edit Contract</h1>
                        <h3>
                            <c:if test="${message=='Edit successful'}">
                                <p class="text-success">${message}</p>
                            </c:if>
                            <c:if test="${message=='Edit unsuccessful'}">
                                <p class="text-danger">${message}</p>
                            </c:if>
                        </h3>
                    </div>
                </div>
                <div class="row bg-light">
                    <div class="col-lg-12 w-100 p-0 m-0">
                        <a class="btn btn-success" href="/customer-using-service"> < Back to List</a>
                    </div>
                </div>
                <div class="row p-2 pt-5">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Contract ID</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="contractID" readonly value="${contract.contractID}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Contract Start Date</label>
                    </div>
                    <div class="col-lg-8 ">
                        <input class="w-auto" type="date" name="contractStartDate" readonly
                               value="${contract.contractStartDate}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Contract End Date</label>
                    </div>
                    <div class="col-lg-8 ">
                        <input class="w-auto" type="date" name="contractEndDate" readonly
                               value="${contract.contractEndDate}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Contract Deposit</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="contractDeposit" readonly value="${contract.contractDeposit}">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee ID</label>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <input type="text" name="employeeID" readonly value="${contract.employee.employeeID}">
                        </div>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Employee Name </label>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <input type="text" name="employeeName" readonly value="${contract.employee.employeeName}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer ID </label>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <input type="text" name="customerID" readonly value="${contract.customer.customerID}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Name: </label>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <input type="text" name="customerName" readonly value="${contract.customer.customerName}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Service </label>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <select class="form-select w-auto" aria-label="Default select example" name="serviceID">
                                <c:forEach items="${servicesList}" var="services">
                                    <option value="${services.serviceID}" ${services.serviceID==contract.services.serviceID?"selected":""}>${services.serviceName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row p-2 justify-content-center pb-4">
                    <div class="col-lg-4 col-md-4 col-sm-4 "></div>
                    <div class="col-lg-4 col-md-4 col-sm-4 ">
                        <input class="btn btn-success" type="submit" id="submit" value="Edit Contract"
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