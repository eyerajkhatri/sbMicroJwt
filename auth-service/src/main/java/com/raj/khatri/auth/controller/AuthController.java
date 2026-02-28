package com.raj.khatri.auth.controller;


import com.raj.khatri.auth.applicationConstants.ApplicationConstants;
import com.raj.khatri.auth.feignInterface.FeignInterface;
import com.raj.khatri.auth.dto.LoginRequest;
import com.raj.khatri.auth.dto.LoginResponse;
import com.raj.khatri.auth.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    FeignInterface feignInterface;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        Map<String, String> user = feignInterface.verifyUserCredentials(request.getUsername());

        String password = null;
        String username = null;


        for (String p : user.values()) {
            password = p;
        }

        for (String u : user.keySet()) {
            username = u;
        }


        if (!encoder.matches(request.getPassword(), password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ApplicationConstants.invalid_credentials);
        }

        String token = jwtService.generateToken(username);

        return new LoginResponse(token);
    }
}
