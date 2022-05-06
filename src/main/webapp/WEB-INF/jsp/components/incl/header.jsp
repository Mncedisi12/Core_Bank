<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- main page -->
<header class="main-page-header mb-3 bg-primary">
    <!--container-->
    <div class="container d-flex align-items-center ">
        <!--company name-->
        <div class="company-name">
            Core-Bank
        </div>
        <!-- end of company name-->
        <!--navigation-->
        <nav class="navigation">
            <li><a href="/app/dashboard">Dashboard</a></li>
            <li><a href="/app/payment_history">Payment History</a></li>
            <li><a href="/app/transact_history">Transaction History</a></li>
        </nav>
        <!-- End Of navigation-->
        <div class="display-name ms-auto text-white">
            <i class="fa fa-user-circle text-success me-2"></i>Welcome: <span>${user.first_name}  ${user.last_name}</span>
        </div>

        <a href="/logout" class="btn btn-sm text-white ms-2">
            <i class="fas fa-sign-out-alt" arial-hidden="true">Sign Out</i>
        </a>
    </div>
    <!--end container-->
</header>

<!--end main page-->
