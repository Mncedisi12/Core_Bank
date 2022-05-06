<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/material.css">

    <style>
        *{
            box-sizing: border-box;
        }
        body{
            height: 100vh;
            background-image: url("./static/images/img.jpeg");
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
        }
        .card .card-text{
            font-size: 15px;
        }
    </style>
    <title>Errors</title>
</head>
<body class="d-flex align-items-center justify-content-center">

<!--card : Error Card-->
<div Class="card col-4 alert alert-danger border-danger text-danger">
    <!--card Title-->
    <h3 class="card-title">
        <i class="fa fa-user-circle"></i>Errors:
    </h3>
    <hr>
    <!--card body-->
    <div class="card-body">
        <p class="card-text">
        <!-- Display Message-->
            <c:if test="${requestScope.error != null}">
                <div class="alert alert-danger text-center border border-danger">
                    <b>${requestScope.error} </b>
                </div>
            </c:if>
        <!-- End Of Display Message-->
        </p>
    </div>
    <!--End Of card body-->
    <hr>
    <a href="/login" class="btn btn-ms btn-danger">
        <i class="fa-arrow-alt-circle-left md-1"></i>Back
    </a>

    <!--End Of Error Card-->
</div>
<!--End Of Card Title-->

</body>
</html>