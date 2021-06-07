<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 6/4/2021
  Time: 11:38 AM
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
                        <h1>Create Service</h1>
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
                        <a class="btn btn-success" href="../../view/furama/furama.jsp"> < Back to Home</a>
                    </div>
                </div>
                <div class="row p-2 pt-5">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Service ID: </label>
                    </div>
                    <div class="col-lg-8 ">
                        <input type="text" name="serviceID">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Service Name: </label>
                    </div>
                    <div class="col-lg-8 ">
                        <input type="text" name="serviceName">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4  text-right">
                        <label class="font-weight-bold">Service Area: </label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="serviceArea">

                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Service Cost: </label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="serviceCost">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Service Max People: </label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="serviceMaxPeople">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Rent Type: </label>
                    </div>
                    <div class="col-lg-8">
                        <select class="form-select w-auto" aria-label="Default select example" name="rentTypeID">
                            <c:forEach items="${rentTypeList}" var="rentType">
                                <option value="${rentType.rentTypeID}">${rentType.rentTypeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row p-2 ">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold">Service Type: </label>
                    </div>
                    <div class="col-lg-8">
                        <select class="form-select w-auto" aria-label="Default select example" name="serviceTypeID" onchange="changeServiceType(this.value)">
                            <c:forEach items="${serviceTypeList}" var="serviceType">
                                <option value="${serviceType.serviceTypeID}">${serviceType.serviceTypeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold" id="labStandardRoom">Standard Room: </label>
                    </div>
                    <div class="col-lg-8 ">
                        <input type="text" name="standardRoom" id="ipStandardRoom">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold" id="labDescription">Description Other Convenience: </label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="descriptionOtherConvenience" id="ipDescription">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold" id="labPoolArea">Pool Area: </label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="poolArea" id="ipPoolArea">
                    </div>
                </div>
                <div class="row p-2" >
                    <div class="col-lg-4 text-right">
                        <label class="font-weight-bold" id="labNumberFloor">Number of Floors: </label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" name="numberOfFloors" id="ipNumberFloor">
                    </div>
                </div>
                <div class="row p-2 justify-content-center pb-4">
                    <div class="col-lg-4 col-md-4 col-sm-4 "></div>
                    <div class="col-lg-4 col-md-4 col-sm-4 ">
                        <input class="btn btn-success" type="submit" id="submit" value="Create Villa"
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

<script>
function changeServiceType(value) {
    document.getElementById("labStandardRoom").style.display = "block";
    document.getElementById("ipStandardRoom").style.display = "block";
    document.getElementById("labDescription").style.display = "block";
    document.getElementById("ipDescription").style.display = "block";
    document.getElementById("labPoolArea").style.display = "block";
    document.getElementById("ipPoolArea").style.display = "block";
    document.getElementById("labNumberFloor").style.display = "block";
    document.getElementById("ipNumberFloor").style.display = "block";
    if(value==2){
        document.getElementById("labPoolArea").style.display = "none";
        document.getElementById("ipPoolArea").style.display = "none";    }
    if(value==3){
        document.getElementById("labStandardRoom").style.display = "none";
        document.getElementById("ipStandardRoom").style.display = "none";
        document.getElementById("labDescription").style.display = "none";
        document.getElementById("ipDescription").style.display = "none";
        document.getElementById("labPoolArea").style.display = "none";
        document.getElementById("ipPoolArea").style.display = "none";
        document.getElementById("labNumberFloor").style.display = "none";
        document.getElementById("ipNumberFloor").style.display = "none";
    }
}
</script>
</body>
</html>

