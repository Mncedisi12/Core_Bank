package com.core_bank.interceptors;

import com.core_bank.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AppInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("In Pre Handle Interceptor Method");

        //TODO: CHECK REQUEST URI:
        if (request.getRequestURI().startsWith("/app")){
            //Get Session:
            HttpSession session = request.getSession();

            //TODO: Get Token Stored In the Session:
            String token= (String) session.getAttribute("token");
            System.out.println(token);

            //TODO: Get User Stored In The Session
            User user = (User) session.getAttribute("user");

            //TODO: Check If Authenticated:
           // boolean isAuthenticated = (boolean) session.getAttribute("authenticated");

            //TODO: VALIDATE SESSION ATTRIBUTES:
            if (token == null || user == null ){
                response.sendRedirect("/login");
                return false;
            }
            //End Of Validate Session Objects

        }
        //End Check Request URI
        return true;
    }
    //End Of Handle Method


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("In Post Handle Interceptor Method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("In after Completion Interceptor Method");
    }
}
