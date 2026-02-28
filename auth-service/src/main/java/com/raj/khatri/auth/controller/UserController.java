package com.raj.khatri.auth.controller;


import com.raj.khatri.auth.applicationConstants.ApplicationConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/signup")
    public String signup() {
        return ApplicationConstants.signup;
    }

    @GetMapping("/")
    public String loginPage() {
        return ApplicationConstants.login;
    }

    @GetMapping("/home")
    public String home() {
        return ApplicationConstants.home;
    }


}

