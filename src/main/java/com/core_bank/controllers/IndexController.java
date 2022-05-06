package com.core_bank.controllers;

import com.core_bank.models.User;
import com.core_bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

        @Autowired
        private UserRepository userRepository;
        @GetMapping("/")
        public ModelAndView getIndex(){

            ModelAndView getIndexPage = new ModelAndView("index");
            getIndexPage.addObject("PageTitle","Home");
            System.out.println("In index controller");
            return getIndexPage;
        }



    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getErrorPage = new ModelAndView("error");
        System.out.println("In Error Page Controller");
        getErrorPage.addObject("PageTitle","Errors");
        return getErrorPage;
    }

    @GetMapping("/verify")
    public ModelAndView getVerify(@RequestParam("token")String token,@RequestParam("code") String code){
        //set View
        ModelAndView getVerifyPage;

        //Get Token
        String dbToken = userRepository.checkToken(token);

        //Check token
        if (dbToken == null){
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject("error","The Session Has Expired");

            return getVerifyPage;
        }
        //End Of Check token

        //Update and Verify Account
        userRepository.verifyAccount(token,code);

        getVerifyPage = new ModelAndView("login");
        System.out.println("In Verify Account Controller");
        getVerifyPage.addObject("success","Account Verified Successfully, Please proceed to Log-In");
        return getVerifyPage;
    }
}
