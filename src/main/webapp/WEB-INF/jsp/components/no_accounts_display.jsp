<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- container: No Account -->
<div class="container">
    <!-- Card: No Account -->
    <div class="card no-accounts-card">
        <!-- card body -->
        <div class="card-body">
            <!-- Card Title -->
            <h1 class="card-title">
                <i class="fas fa-ban text-danger">No Registered Accounts</i> <!--No Registered Accounts-->

            </h1>
            <!-- End Of Card Title -->
            <hr>
            <!-- Card Text -->
            <div class="card-text">
                You currently do not have any Registered accounts. <br>
                Please click below to Register / add a new account.
            </div>
            <!-- End Of Card Text -->
            <br>
            <button id="" class="btn btn-primary btn-lg shadow" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                <i class="fa fa-credit-card"></i>  Add New Account
            </button>
        </div>
        <!-- End Of Card Body -->
    </div>
    <!-- End Of Card :No Account -->
</div>

<!-- End OF Container: No Account -->
