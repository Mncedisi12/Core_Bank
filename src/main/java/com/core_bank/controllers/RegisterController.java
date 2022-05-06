package com.core_bank.controllers;
import com.core_bank.helpers.HTML;
import com.core_bank.helpers.Token;
import com.core_bank.mailMessenger.MailMessenger;
import com.core_bank.models.User;
import com.core_bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("In Register Page Controller");
        getRegisterPage.addObject("PageTitle","Register");
        return getRegisterPage;
    }


    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser") User user,
                                 BindingResult result,
                                 @RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("id_number") String id_number,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password) throws MessagingException {

        ModelAndView registrationPage = new ModelAndView("register");

        //check errors

        if (result.hasErrors() && confirm_password.isEmpty()){
            registrationPage.addObject("confirm_pass","The confirm password field is required");
            return registrationPage;
        }


        //TODO: CHECK PASSWORD MATCH:

        if(!password.equals(confirm_password)){

            registrationPage.addObject("passwordMisMatch","Passwords don't match");
            return registrationPage;
        }

        //TODO:validate
        if (id_number.isEmpty() ||id_number.length() <= 12 || id_number.length() >= 14){
            registrationPage.addObject("invalid","ID number can not be greater, less than 13 OR Empty");
            return registrationPage;
        }



        //TODO: GET TOKEN STRING
        String token = Token.generateToken();

        //TODO: GENERATE RANDOM CODE
        Random rand = new Random();
        int bound = 1234;
        int code = bound * rand .nextInt(bound);

        //TODO: HASH PASSWORD
        String hashed_password = BCrypt.hashpw(password,BCrypt.gensalt());

        //TODO: GET EMAIL HTML BODY
        String emailBody = HTML.htmlEmailTemplate(token,code);

        //TODO: REGISTER USER
        userRepository.registerUser(first_name,last_name,id_number,email,hashed_password,token,Integer.toString(code));

        //TODO: SEND EMAIL NOTIFICATION
        MailMessenger.htmlEmailMessenger("no-reply@corebank.com", email," Verify Account",emailBody);

        //TODO: RETURN REGISTRATION PAGE
        String successMessage = "Account Registered Successfully, Please Verify Your Account In You Email";
        registrationPage.addObject("success",successMessage);

        return registrationPage;

    }
}
