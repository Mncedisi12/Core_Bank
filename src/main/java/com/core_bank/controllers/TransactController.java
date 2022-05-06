package com.core_bank.controllers;

import com.core_bank.models.User;
import com.core_bank.repository.AccountRepository;
import com.core_bank.repository.PaymentRepository;
import com.core_bank.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TransactRepository transactRepository;


    User user;
    double currentBalance;
    double newBalance;
    LocalDateTime currentDateTime = LocalDateTime.now();


    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount")String depositAmount,
                          @RequestParam("account_id")String accountID,
                          HttpSession session,
                          RedirectAttributes redirectAttributes){

                //TODO: CHECK EMPTY STRINGS:
                if (depositAmount.isEmpty() || accountID.isEmpty()){
                    redirectAttributes.addFlashAttribute("error","Deposit Amount or Account ID Cannot Be Empty");
                    return "redirect/app/dashboard";
                }

                //TODO: GET LOGGED IN USER:
                user =(User)session.getAttribute("user");

                //TODO: GET CURRENT BALANCE:
                int acc_id = Integer.parseInt(accountID);
                double depositAmountValue = Double.parseDouble(depositAmount);


                //TODO: CHECK DEPOSIT AMOUNT:
                if (depositAmountValue == 0){

                    redirectAttributes.addFlashAttribute("error","Deposit Amount Cannot Be a ZERO Value");
                    return "redirect/app/dashboard";

                }

                //TODO: UPDATE BALANCE:

                currentBalance = accountRepository.getAccountBalance(user.getUser_id(),acc_id);

                newBalance = currentBalance + depositAmountValue;

                //update balance
                accountRepository.changeAccountBalanceById(newBalance,acc_id);

                //log successful transaction:
                transactRepository.logTransaction(acc_id,"Deposit",depositAmountValue,"online","success","Deposit Transaction Successfully",currentDateTime);

                redirectAttributes.addFlashAttribute("success","Amount Deposited Successfully");
                return "redirect/app/dashboard";



    }
    // End of Deposit Method


    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from")String transfer_from,
                           @RequestParam("transfer_to")String transfer_to,
                           @RequestParam("transfer_amount")String transfer_amount,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        String errorMsg;

        //TODO: CHECK FOR EMPTY FIELDS:
        if (transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()){
            errorMsg  = "Account Transfer TO, FROM AND Amount Cannot Be Empty ";
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "redirect/app/dashboard";
        }

        //TODO: CONVERT VARIABLES:
        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        //TODO: TRANSFERRING INTO SAME ACCOUNT:
        if (transferFromId == transferToId){
            errorMsg  ="Cannot Transfer Into The Same Account, Please Select The Appropriate Account";
            redirectAttributes.addFlashAttribute("error",errorMsg );
            return "redirect/app/dashboard";
        }

        //TODO: CHECK ZERO VALUES:
        if (transferAmount == 0){

            errorMsg  ="Cannot Transfer An Amount Of ZERO, Please Enter a Value Greater than 0 (ZERO)";
            redirectAttributes.addFlashAttribute("error",errorMsg );
            return "redirect/app/dashboard";
        }



        //TODO: GET LOGGED IN USER:
        user = (User) session.getAttribute("user");


        //TODO: GET CURRENT BALANCE:
        double currentBalanceOfAccountTransferringFrom = accountRepository.getAccountBalance(user.getUser_id(),transferFromId);

        //TODO: CHECK IF TRANSFER AMOUNT IS MORE THAN CURRENT BALANCE:
        if (currentBalanceOfAccountTransferringFrom < transferAmount){
            errorMsg  = "Insufficient Funds";
            //log failed transaction:
            transactRepository.logTransaction(transferFromId,"Transfer",transferAmount,"online","failed","Insufficient Funds",currentDateTime);
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "redirect/app/dashboard";
        }

        double currentBalanceOfAccountTransferringTO = accountRepository.getAccountBalance(user.getUser_id(),transferToId);

        //TODO: SET NEW BALANCE:
        double newBalanceOfAccountTransferringFrom = currentBalanceOfAccountTransferringFrom - transferAmount;
        double newBalanceOfAccountTransferringTo = currentBalanceOfAccountTransferringTO + transferAmount;

        //change balance of the account transferring from
        accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringFrom, transferFromId);

        //change balance of the account transferring to
        accountRepository.changeAccountBalanceById(newBalanceOfAccountTransferringTo, transferToId);

        //log successful transaction:
        transactRepository.logTransaction(transferFromId,"Transfer",transferAmount,"online","success","Transfer Transaction Successfully",currentDateTime);

        String successMsg  ="Amount transfer Successfully";
        redirectAttributes.addFlashAttribute("error",successMsg );
        return "redirect/app/dashboard";
    }
    // End of Transfer Method


    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("withdrawal_amount")String withdrawalAmount,
                           @RequestParam("account-id")String accountID,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        String errorMsg;

        //TODO: CHECK EMPTY VALUES:
        if (withdrawalAmount.isEmpty() || accountID.isEmpty()){

            errorMsg  = "withdrawal Amount and Account Withdrawing From Cannot Be Empty ";
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "redirect/app/dashboard";
        }

        //TODO: CONVERT VARIABLES:
        double withdrawal_amount = Double.parseDouble(withdrawalAmount);
        int account_id = Integer.parseInt(accountID);

        //TODO: CHECK IF WITHDRAWAL AMOUNT IS MORE THAN CURRENT BALANCE:
        if (currentBalance < withdrawal_amount){
            errorMsg  = "Insufficient Funds";
            //log failed transaction:
            transactRepository.logTransaction(account_id,"Withdrawal",withdrawal_amount,"online","failed","Insufficient Funds",currentDateTime);
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "redirect/app/dashboard";
        }


        //TODO: CHECK ZERO VALUES:
        if (withdrawal_amount == 0){

            errorMsg  = "withdrawal Amount Cannot Be ZERO, Please Enter a Value Greater than 0 (ZERO)";
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "redirect/app/dashboard";
        }

        //TODO: GET LOGGED IN USER:

        user = (User) session.getAttribute("user");

        //TODO: GET CURRENT BALANCE:
        currentBalance= accountRepository.getAccountBalance(user.getUser_id(),account_id);

        //TODO: SET NEW BALANCE:
        newBalance = currentBalance - withdrawal_amount;

        //TODO: UPDATE ACCOUNT BALANCE:
        accountRepository.changeAccountBalanceById(newBalance,account_id);

        //log successful transaction:
        transactRepository.logTransaction(account_id,"Withdrawal",withdrawal_amount,"online","success","Withdrawal Transaction Successfully",currentDateTime);

        String successMsg  = "withdrawal Amount Successfully";
        redirectAttributes.addFlashAttribute("success",successMsg);
        return "redirect/app/dashboard";

    }

    // End Of Withdraw Method

    @PostMapping("/payment")
    public String payment(@RequestParam("beneficiary")String beneficiary,
                          @RequestParam("account_number")String account_number,
                          @RequestParam("account_id")String account_id,
                          @RequestParam("reference")String reference,
                          @RequestParam("payment_amount")String payment_amount,
                          HttpSession session,
                          RedirectAttributes redirectAttributes){

        String errorMsg;
        String successMsg;

        //TODO: CHECK FOR EMPTY VALUE:
        if (beneficiary.isEmpty() || account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()){

            errorMsg  = "Beneficiary, Account Number, Account Paying From and Payment Amount Cannot Be Empty ";
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "dashbord";

        }

        //TODO: CONVERT VARIABLE:
        int accountID = Integer.parseInt(account_id);
        double paymentAmount = Double.parseDouble(payment_amount);


        //TODO: CHECK FOR ZERO VALUES:

        if (paymentAmount == 0){
            errorMsg  = "Payment Amount Cannot Be ZERO, Please Enter a Value Greater than 0 (ZERO)";
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "redirect/app/dashboard";

        }

        //TODO: GET LOGGED IN USER:
        user =(User) session.getAttribute("user");

        //TODO: GET CURRENT BALANCE:

        currentBalance = accountRepository.getAccountBalance(user.getUser_id(),accountID );

        //TODO: CHECK IF PAYMENT AMOUNT IS MORE THAN CURRENT BALANCE:
        if (currentBalance < paymentAmount){
            errorMsg  = "Insufficient Funds";
            //TODO: MAKE PAYMENT:
            String reasonCode = "Could Not Process Payment Due to Insufficient Funds";
            paymentRepository.makePayment(accountID,beneficiary,account_number,paymentAmount,reference,"failed",reasonCode,currentDateTime);

            //log failed transaction:
            transactRepository.logTransaction(accountID,"Payment",paymentAmount,"online","failed","Insufficient Funds",currentDateTime);
            redirectAttributes.addFlashAttribute("error",errorMsg);
            return "redirect/app/dashboard";
        }

        //TODO: SET NEW BALANCE FOR ACCOUNT PAYING FROM:
        newBalance = currentBalance - paymentAmount;

        //TODO: MAKE PAYMENT:
        String reasonCode = "payment Processed Successfully";

        paymentRepository.makePayment(accountID,beneficiary,account_number,paymentAmount,reference,"success",reasonCode,currentDateTime);


        //TODO: UPDATE AMOUNT IN ACCOUNT PAYING FROM:
        accountRepository.changeAccountBalanceById(newBalance,accountID);

        //log failed transaction:
        transactRepository.logTransaction(accountID,"Payment",paymentAmount,"online","passed"," Payment Successfully",currentDateTime);
        successMsg  = reasonCode;
        redirectAttributes.addFlashAttribute("success",successMsg);
        return "redirect/app/dashboard";
    }

}

