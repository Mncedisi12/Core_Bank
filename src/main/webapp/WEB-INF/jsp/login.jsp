<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/default.css">
    <link rel="stylesheet" href="../css/bootstrap.css">

    <title>Login</title>
</head>
<body class="d-flex align-items-center justify-content-center">

<!-- login Form Card-->
<div class="card login-form-card col-4 bg-transparent border-0">
    <!-- Card body-->
    <div class="card-body">
        <!-- Card Header-->
        </h1 class="form-header card-title mb-3" >
        <i class="fa fa-user-circle"></i>Login
        </h1>
        <!-- End Card Header-->

        <!-- Display Message-->
        <c:if test="${requestScope.success != null}">
            <div class="alert alert-success text-center border-success">
                <b>${requestScope.success}</b>
            </div>
        </c:if>
        <!--End Of Display Message-->

        <!-- Display Message-->
        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger text-center border-danger">
                <b>${requestScope.error}</b>
            </div>
        </c:if>
        <!--End Of Display Message-->


        <!-- Display Message-->
        <c:if test="${logged_out != null}">
            <div class="alert alert-info text-center border-info">
                <b>${logged_out}</b>
            </div>
        </c:if>
        <!--End Of Display Message-->

        <!-- login Form-->
        <form action="/login" method="POST" class="login-form">

            <div class="form-group col">
                <input type="text" name="email" class="form-control form-control-lg" placeholder="Enter Email Address"/>
            </div>

            <div class="form-group col">
                <input type="password" name="password" class="form-control form-control-lg" placeholder="Enter Password"/>
            </div>

            <div class="form-group col">
                <input type="hidden" name="_token" value="${token}"/>
            </div>


            <div class="form-group col">
                <button class="btn btn-lg" role="button">Login</button>
            </div>

        </form>
        <!--card text-->
        <p class="card-text text-white my-2">
            Do not have an account? <span class="ms-2 text-warning "><a href="/register" class="btn btn-ms text-warning">Sign Up</a></span>
        </p>

        <!--back button-->
        <small class="text-warning ">
            <i class="fa fa-arrow-alt-circle-left"></i> <a class="btn btn-sm text-warning" href="/">Back</a>
        </small>


    </div>
    <!-- End of Body Card-->
</div>
<!-- End Of login Form Card-->


</body>
</html>