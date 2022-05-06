<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!--container-->
<div class="container d-flex">

    <button id="add-account-btn" class="btn btn-primary btn-lg shadow" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
        <i class="fa fa-credit-card"></i>  Add New Account
    </button>

    <!-- Transaction Button -->
    <button id="transact-btn" class="btn btn-primary btn-lg shadow ms-auto " type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
        <i class="fa fa-wallet"></i> Transact
    </button>

    <!-- End Of Transaction Button  -->


</div>

<!--end container-->

<!-- container: Total Account Balance Display -->
<div class="container d-flex py-3 ">
    <h2 class="me-auto ">Total Accounts Balance:</h2>
    <h2 class="ms-auto ">
        <c:if test="${requestScope.totalBalance != null}">
             <c:out value="${totalBalance}"/>
        </c:if>
    </h2>
</div>
<!-- End Of Container: Total Account Balance Displayed -->

<!-- container: Accordion manu/ drop down  -->
<div class="container">
    <!-- Accordion manu -->
        <c:if test="${requestScope.userAccounts != null }">

            <c:forEach items="${requestScope.userAccounts}" var="account">
                    <div class="accordion" id="accordionPanelsStayOpenExample">
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="panelsStayOpen-headingOne">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-${account.account_id}" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                                    ${account.account_name}
                                </button>
                            </h2>
                            <div id="panelsStayOpen-${account.account_id}" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">
                                <div class="accordion-body">
                                <!--Account Detailed list-->
                                  <ul class="list-group list-group-flush">
                                    <li class="list-group-item d-flex">Account Name <span class="ms-auto"><br>${account.account_name}</br></span></li>
                                    <li class="list-group-item d-flex">Account Number <span class="ms-auto"><br>${account.account_number}</br></span></li>
                                    <li class="list-group-item d-flex">Account Type <span class="ms-auto"><br>${account.account_type}</br></span></li>
                                    <li class="list-group-item d-flex">Account Balance <span class="ms-auto"><br>${account.balance}</br></span></li>

                                  </ul>
                                <!--End Of Account Detailed List-->

                                </div>
                            </div>
                        </div>

                     </div>
            </c:forEach>

        </c:if>

    <!-- End Of Accordion manu -->
</div>
<!--End Of container: Accordion manu/ drop down  -->
<!--Payments Form Card-->
