<%--
  Created by IntelliJ IDEA.
  User: DmD
  Date: 5/30/2021
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Furama Resort</title>

    <link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/css/bootstrap.css">


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
<div class="modal fade" id="exampleModalLongView" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLongTitleView"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header center">
                <h5 class="modal-title text-danger w-100 text-center" id="exampleModalLongTitleView">
                    product list</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-justify">
                <div class="row">
                    <div class="col-lg-4 text-right ">
                        <p># </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="productId"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>product name: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="productName"></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-4 text-right ">
                        <p> price</p>
                    </div>
                    <div class="col-lg-8">
                        <span id="productPrice"></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>quantity: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="productQuantity"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>color: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="productColor"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-right">
                        <p>category: </p>
                    </div>
                    <div class="col-lg-8">
                        <span id="ProductCategory"></span>
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
    function sendDataToModalView(id, name, typeID, birthday, gender, idCard, phone, email, address) {
        document.getElementById("idCustomerView").innerText = id;
        document.getElementById("nameCustomerView").innerText = name;
        if (typeID == 1) {
            document.getElementById("typeIDCustomerView").innerText = "Diamond";
        } else if (typeID == 2) {
            document.getElementById("typeIDCustomerView").innerText = "Platinum";
        } else if (typeID == 3) {
            document.getElementById("typeIDCustomerView").innerText = "Gold";
        } else if (typeID == 4) {
            document.getElementById("typeIDCustomerView").innerText = "Silver";
        } else {
            document.getElementById("typeIDCustomerView").innerText = "Member";
        }
        document.getElementById("birthdayCustomerView").innerText = birthday;
        if (gender == 0) {
            document.getElementById("genderCustomerView").innerText = "Male";
        } else {
            document.getElementById("genderCustomerView").innerText = "Female";
        }
        document.getElementById("idCardCustomerView").innerText = idCard;
        document.getElementById("phoneCustomerView").innerText = phone;
        document.getElementById("emailCustomerView").innerText = email;
        document.getElementById("addressCustomerView").innerText = address;
    }
</script>

<%--Phân trang--%>

<script src="../../lib/bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
<script src="../../lib/bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>
<script src="../../lib/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../lib/datatables/js/dataTables.bootstrap4.min.js"></script>>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });
</script>
</body>
<script src="../../lib/bootstrap-4.6.0-dist/js/jquery-3.6.0.min.js"></script>
<script src="../../lib/bootstrap-4.6.0-dist/js/bootstrap.bundle.js"></script>
</body>
</html>
