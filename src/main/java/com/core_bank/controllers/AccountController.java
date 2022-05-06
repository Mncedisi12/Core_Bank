package com.core_bank.controllers;

import com.core_bank.helpers.GenAccountNumber;
import com.core_bank.models.User;
import com.core_bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name")String accountName,
                                @RequestParam("account_type")String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session){

        //TODO: CHECK EMPTY STRING
        if (accountName.isEmpty() || accountType.isEmpty()){
            redirectAttributes.addFlashAttribute("error","Account Name and Type Cannot be Empty!");
            return "redirect:/app/dashboard";
        }

        //TODO: GET LOGGED IN USER

        User user = (User)session.getAttribute("user");

        //TODO: GENERATE ACCOUNT NUMBER
        int setAccountNumber = GenAccountNumber.generateAccountNumber();
        String bankAccountNumber = Integer.toString(setAccountNumber);

        //TODO:CREATE ACCOUNT
        accountRepository.createBankAccount(user.getUser_id(),bankAccountNumber,accountName,accountType);

        //Success Message
        redirectAttributes.addFlashAttribute("success","Account Created Successfully");

        return "redirect:/app/dashboard";

    }
}
