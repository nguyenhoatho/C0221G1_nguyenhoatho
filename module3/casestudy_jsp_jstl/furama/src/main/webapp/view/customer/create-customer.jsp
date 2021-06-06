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
<div class="container mb-0">
    <form method="post">
        <div class=" row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8 bg-info">
                <div class="row p-3 bg-light">
                    <div class="col-lg-12 text-center">
                        <h1>Create Customer</h1>
                        <h3>
                            <c:if test="${message=='Create successful'}">
                                <p class="text-success">${message}</p>
                            </c:if>
                            <c:if test="${message=='Create unsuccessful'}">
                                <p class="text-danger">${message}</p>
                            </c:if>
                        </h3>
                    </div>
                </div>
                <div class="row bg-light">
                    <div class="col-lg-12 w-100 p-0 m-0">
                        <a class="btn btn-success" href="/customer"> < Back to List</a>
                    </div>
                </div>
                <div class="row p-2 pt-5">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Name</label>
                    </div>
                    <div class="col-lg-8 ">
                        <input type="text" name="customerName">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Type </label>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <select class="form-select w-auto" aria-label="Default select example"
                                    name="customerTypeID">
                                <c:forEach items="${customerTypeList}" var="customerType">
                                    <option value="${customerType.customerTypeID}">${customerType.customerTypeName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Birthday</label>
                    </div>
                    <div class="col-lg-8">
                        <input class="w-auto" type="date" name="customerBirthday">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Gender</label>
                    </div>
                    <div class="col-lg-8">
                        <select class="form-select w-auto" aria-label="Default select example" name="customerGender">
                            <option value="0">Male</option>
                            <option value="1">Female</option>
                        </select>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer ID Card</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="customerIDCard">
                    </div>
                </div>
                <div class="row p-2 ">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Phone</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="customerPhone">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Email</label>
                    </div>
                    <div class="col-lg-8 ">
                        <input type="text" name="customerEmail">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Customer Address</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="customerAddress">
                    </div>
                </div>
                <div class="row p-2 justify-content-center pb-4">
                    <div class="col-lg-4 col-md-4 col-sm-4 "></div>
                    <div class="col-lg-4 col-md-4 col-sm-4 ">
                        <input class="btn btn-success" type="submit" id="submit" value="Create Customer"
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



