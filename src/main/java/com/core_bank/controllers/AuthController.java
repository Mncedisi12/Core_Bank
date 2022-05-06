package com.core_bank.controllers;

import com.core_bank.helpers.Token;
import com.core_bank.models.User;
import com.core_bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView getLoginPage = new ModelAndView("login");
        System.out.println("In Login Page Controller");
        // Set Token
        String token = Token.generateToken();

        // send token to view
        getLoginPage.addObject("token",token);
        getLoginPage.addObject("PageTitle","Login");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email")String email,
                        @RequestParam("password")String password,
                        @RequestParam("_token")String token,
                        Model model,
                        HttpSession session){

        //TODO: VALIDATE INPUT FIELDS
        if (email.isEmpty() || email == null || password.isEmpty() || password == null){
            model.addAttribute("error","Username or Password Can Not Be Empty");
            return "login";
        }

        //TODO: CHECK IF EMAIL EXIST
        String getEmailInDatabase = userRepository.getUserEmail(email);

        if ( getEmailInDatabase != null){
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);

            //validate password
            if (!BCrypt.checkpw(password, getPasswordInDatabase)){
                model.addAttribute("error","Incorrect Username or Password");
                return "login";
            }

        }else{
            model.addAttribute("error","Something went wrong. Please Contact Support");
            return "error";
        }
        // End Of Check Email Exits

        //TODO: CHECK IF USER ACCOUNT IS VERIFY

        int verified = userRepository.isVerified(getEmailInDatabase);

        if (verified != 1){
            String msg = "This Account Is Not Verified, Please Check Your Email And Verify Account";
            model.addAttribute("error",msg);
            return "login";
        }

        //TODO: PROCEED TO LOGIN IN THE USER
        User user = userRepository.getUserDetails(getEmailInDatabase);

        session.setAttribute("user",user);
        session.setAttribute("token",token);
        session.setAttribute("authenticated",true);

        return "redirect:/app/dashboard";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out","Logged out successfully");

        return "redirect:/login";
    }

}
