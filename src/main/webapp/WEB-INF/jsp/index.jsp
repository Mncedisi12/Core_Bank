<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/default.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Home</title>
</head>
<body class ="d-flex align-items-center ">

<div id="core-text-card" class="card col-6 bg-transparent">
    <!--card body-->
    <div class="card body col-6">
        <!--card Header-->
        <h1 class="mb-3 text-secondary">Core Bank</h1>
        <!--End card Header-->

        <!--card title-->
        <h5 class="card-title text-primary text-lg" >
            Flexible Banking Solution
        </h5>
        <!--end of card title-->

        <!--card text-->
        <p class="card-text text-primary text-md">
            easy way to bank with core bank
        </p>
        <!--End Of card text-->

        <!--wrapper button-->
        <div class="button-wrapper d-flex align-items-center">
            <a href="/register" class="btn btn-lg" role="button"> Register</a>
            <a href="/login" class="btn btn-lg" role="button"> Login</a>
        </div>
        <!--End Of Wrapper button-->
    </div>
    <!-- end of card body-->

</div>

</body>
</html>