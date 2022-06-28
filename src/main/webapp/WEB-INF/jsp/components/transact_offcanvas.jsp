<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!--start of transact OffCanvas-->
<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title text-black" id="offcanvasExampleLabel">Transact</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <!-- Offcanvas transact body-->
    <div class="offcanvas-body">
        <small class="card-text text-black">
            Choose an Option below to perform a transaction
        </small>
        <!-- Transaction Type Drop List -->
        <select name="transact-type" class="form-control my-2" id="transact-type">
            <option value="">-- Select Transaction Type --</option>
            <option value="payment">Payment --</option>
            <option value="transfer">Transfer</option>
            <option value="deposit">Deposit</option>
            <option value="withdraw">Withdraw</option>
        </select>
        <!-- End Of Transaction Type Drop List -->

               <!--Payments Form Card-->
         <c:import url="components/transact_forms/payment_form.jsp"/>
               <!--transfer Form Card-->
         <c:import url="components/transact_forms/transfer_form.jsp"/>
               <!--deposit Form Card-->
         <c:import url="components/transact_forms/deposit_form.jsp"/>
               <!--withdraw Form Card-->
         <c:import url="components/transact_forms/withdraw_form.jsp"/>

    </div>
    <!--End Of offcanvas transact body-->
</div>
<!--End of transact OffCanvas-->