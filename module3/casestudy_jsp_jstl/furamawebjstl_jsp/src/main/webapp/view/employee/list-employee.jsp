<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/30/2021
  Time: 2:38 PM
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

        .table .btn {
            width: 60px;
            height: 35px;
        }
    </style>
</head>
<body>
<div>
<jsp:include page="../../view/furama/furama-header.jsp"></jsp:include>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-lg-12">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="text-center">Employee List</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-9 col-md-8 col-sm-6 col-6 m-0">
                    <h1 class="text-left m-0 p-0">
                        <a class="btn btn-success btnCreate" href="/employee?action=create">Create</a>
                    </h1>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 col-6 m-0">
                    <form class="d-flex m-0 p-0" method="get" action="/employee">
                        <input name="action" value="search" hidden>
                        <input class="form-control me-2" type="text" name="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success ml-2" type="submit">Search</button>
                    </form>
                </div>
            </div>
            <table class="table table-striped">
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>ID Card</th>
                    <th>Phone</th>
                    <th>View</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${employee}" var="employee" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${employee.employeeName}</td>
                        <td>${employee.employeeBirthday}</td>
                        <td>${employee.employeeIDCard}</td>
                        <td>${employee.employeePhone}</td>
                        <td>
                            <button type="button" class="btn btn-info"
                                    onclick="sendDataToModalView('${employee.employeeID}','${employee.employeeName}','${employee.employeeBirthday}','${employee.employeeIDCard}','${employee.employeeSalary}','${employee.employeePhone}','${employee.employeeEmail}','${employee.employeeAddress}','${employee.positionID}','${employee.educationDegreeID}','${employee.divisionID}')"
                                    data-toggle="modal" data-target="#exampleModalLongView">
                                View
                            </button>
                        </td>
                        <td><a class="btn btn-warning" href="employee?action=edit&employeeID=${employee.employeeID}">Edit</a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger"
                                    onclick="sendDataToModalDelete('${employee.employeeID}','${employee.employeeName}')"
                                    data-toggle="modal" data-target="#exampleModalLongDelete">
                                Delete
                            </button>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../../view/furama/furama-footer.jsp"></jsp:include>

<!-- Modal Delete-->
<div class="modal fade" id="exampleModalLongDelete" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLongTitleDelete"
     aria-hidden="true">
    <form action="/employee?action=delete" method="post">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header center">
                    <h5 class="modal-title text-danger w-100 text-center" id="exampleModalLongTitleDelete">Delete
                        Customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body text-center">
                    <input hidden type="text" name="employeeID" id="idEmployeeDelete">
                    <p>Do you want to delete Customer: </p>
                    <h4 class="text-info"><span id="nameEmployeeDelete"></span></h4>
                </div>
                <div class="modal-footer w-100 justify-content-center">
                    <button type="submit" class="btn btn-primary w-25">Yes</button>
                    <button type="button" class="btn btn-secondary w-25" data-dismiss="modal">No</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    function sendDataToModalDelete(id, name) {
        document.getElementById("idEmployeeDelete").value = id;
        document.getElementById("nameEmployeeDelete").innerText = name
    }
</script>

<!-- Modal View-->
<div class="modal fade" id="exampleModalLongView" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLongTitleView"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header center">
                <h5 class="modal-title text-danger w-100 text-center" id="exampleModalLongTitleView">
                    Employee Information</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-justify">
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Employee ID: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="idEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right ">
                        <p>Employee Name: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="nameEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Employee Birthday: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="birthdayEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Employee ID Card: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="idCardEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Employee Salary: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="salaryEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Employee Phone: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="phoneEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Employee Email: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="emailEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Employee Address: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="addressEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Position ID: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="positionIDEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Education Degree ID: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="educationDegreeIDEmployeeView"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>Division ID: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="divisionIDEmployeeView"></span>
                    </div>
                </div>
            </div>
            <div class="modal-footer w-100 justify-content-center">
                <button type="button" class="btn btn-success w-25" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    function sendDataToModalView(id, name, birthday, idCard, salary, phone, email, address, positionID, educationDegreeID, divisionID) {
        document.getElementById("idEmployeeView").innerText = id;
        document.getElementById("nameEmployeeView").innerText = name;
        document.getElementById("birthdayEmployeeView").innerText = birthday;
        document.getElementById("idCardEmployeeView").innerText = idCard;
        document.getElementById("salaryEmployeeView").innerText = salary;
        document.getElementById("phoneEmployeeView").innerText = phone;
        document.getElementById("emailEmployeeView").innerText = email;
        document.getElementById("addressEmployeeView").innerText = address;

        if(positionID==1){
            document.getElementById("positionIDEmployeeView").innerText = "Receptionist";
        }else if(positionID==2){
            document.getElementById("positionIDEmployeeView").innerText = "Service";
        }else if(positionID==3){
            document.getElementById("positionIDEmployeeView").innerText = "Specialist";
        }else if(positionID==4){
            document.getElementById("positionIDEmployeeView").innerText = "Supervisor";
        }else {
            document.getElementById("positionIDEmployeeView").innerText = "Director";
        }

        if(educationDegreeID==1){
            document.getElementById("educationDegreeIDEmployeeView").innerText = "Intermediate";
        }else if(educationDegreeID==2){
            document.getElementById("educationDegreeIDEmployeeView").innerText = "College";
        }else if(educationDegreeID==3){
            document.getElementById("educationDegreeIDEmployeeView").innerText = "University";
        }else {
            document.getElementById("educationDegreeIDEmployeeView").innerText = "Graduate";
        }

        if(divisionID==1){
            document.getElementById("divisionIDEmployeeView").innerText = "Sales-Marketing Department";
        }else if(divisionID==2){
            document.getElementById("divisionIDEmployeeView").innerText = "Administrative Department";
        }else if(divisionID==3){
            document.getElementById("divisionIDEmployeeView").innerText = "Service Department";
        }else {
            document.getElementById("divisionIDEmployeeView").innerText = "Management Department";
        }
    }
</script>
</body>
</html>

