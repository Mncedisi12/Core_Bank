<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

        <!-- Card:deposit Card-->
        <card class=" card deposit-card">
            <!-- Card Body -->
            <div class="card-body">

                <!-- Deposit Form -->

                <form action="/transact/deposit " method="post" class="deposit-form">
                    <!-- Form Group -->
                    <div class="form-group mb-2 ">
                        <label for=""> Enter Deposit Amount</label>
                        <input type="text" name="deposit_amount" class="form-control" placeholder="Enter Deposit Amount">

                    </div>
                    <!-- End Of Form Group -->


                    <!-- Form Group -->
                    <div class="form-group mb-2">
                        <label for="">Select Account</label>
                        <select name="account_id" class="form-control " id="">
                            <option value="">-- Select Account --</option>
                            <c:if test="${userAccounts != null}">
                                <c:forEach items="${userAccounts}" var="selectAccount">
                                    <option value="${selectAccount.account_id}">${selectAccount.account_name}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <!-- End Of Select Account Option -->
                    </div>
                    <!-- End Of Form Group -->


                    <!-- Form Group -->
                    <div class="form-group mb-2 ">
                        <button id="" class="btn btn-md transact-btn btn-primary">Deposit</button>

                    </div>
                    <!-- End Of Form Group -->
                </form>
                <!-- End Of Deposit Form  -->

            </div>
            <!-- End oF Card Body -->

        </card>

        <!-- End Of deposit Card -->
