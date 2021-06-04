<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/30/2021
  Time: 3:24 PM
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
    </style>
</head>
<body>
<div class="container-fluid col-lg-12">
    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="/"><img class="mb-1" src="../../img/icon.png" style="width: auto;height: 2.5rem"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Customer
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/customer/list-customer.jsp">List Customer</a>
                        <a class="dropdown-item" href="../../view/customer/create-customer.jsp">Create Customer</a>
                        <a class="dropdown-item" href="../../view/customer/edit-customer.jsp">Edit Customer</a>
                        <a class="dropdown-item" href="../../view/customer/delete-customer.jsp">Delete Customer</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-1" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Employee
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/employee/list-employee.jsp">List Employee </a>
                        <a class="dropdown-item" href="../../view/employee/create-employee.jsp">Create Employee </a>
                        <a class="dropdown-item" href="../../view/employee/edit-employee.jsp">Edit Employee </a>
                        <a class="dropdown-item" href="../../view/employee/delete-employee.jsp">Delete Employee </a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-2" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Service
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/service/list-service.jsp">List Service</a>
                        <a class="dropdown-item" href="../../view/service/create-service.jsp">Create Service</a>
                        <a class="dropdown-item" href="../../view/service/edit-service.jsp">Edit Service</a>
                        <a class="dropdown-item" href="../../view/service/delete-service.jsp">Delete Service</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-3" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Contract
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/contract/list-contract.jsp">List Contract</a>
                        <a class="dropdown-item" href="../../view/contract/create-contract.jsp">Create Contract</a>
                        <a class="dropdown-item" href="../../view/contract/edit-contract.jsp">Edit Contract</a>
                        <a class="dropdown-item" href="../../view/contract/delete-contract.jsp">Delete Contract</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-4" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Contract Detail
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/contract_detail/list-contract-detail.jsp">List Contract Detail</a>
                        <a class="dropdown-item" href="../../view/contract_detail/create-contract-detail.jsp">Create Contract Detail</a>
                        <a class="dropdown-item" href="../../view/contract_detail/edit-contract-detail.jsp">Edit Contract Detail</a>
                        <a class="dropdown-item" href="../../view/contract_detail/delete-contract-detail.jsp">Delete Contract Detail</a>
                    </div>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="text-center">Contract Detail List</h1>
            <table class="table table-striped">
                <tr>
                    <th>STT</th>
                    <th>Contract Detail ID</th>
                    <th>Contract ID</th>
                    <th>Attach Service ID</th>
                    <th>Quantity</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${contracDetails}" var="contractDetail" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${contractDetail.contractDetailID}</td>>
                        <td>${contractDetail.contractID}</td>>
                        <td>${contractDetail.attachServiceID}</td>>
                        <td>${contractDetail.contractDetailQuantity}</td>>
                        <td><a href="contractDetail?action=edit&id=${contractDetail.contractID}">Edit</a></td>
                        <td><a href="contractDetail?action=delete&id=${contractDetail.contractID}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row text-center p-4">
        <div class="col-lg-12">
            <p>Copyright © 2018 Furama Hotels International. All Rights Reserved.</p>
        </div>
    </div>
</div>
</body>
</html>

