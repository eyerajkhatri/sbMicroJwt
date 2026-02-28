package com.raj.khatri.userservice.userLoginController;


import com.raj.khatri.userservice.userLoginDTO.UserLoginDTO;
import com.raj.khatri.userservice.uerFetchService.UserFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class UserLogin {

    @Autowired
    UserFetchService userFetchService;

    @GetMapping("/VerifyUser")
    public Map<String, String> verifyUserCredentials(@RequestParam String userName) {

        UserLoginDTO userLoginDTO = userFetchService.verifyUserCredentials(userName);


        String username = userLoginDTO.getUserName();

        String password = userLoginDTO.getPassword();

        Map<String, String> user = new LinkedHashMap<>();

        user.put("username", username);
        user.put("password", password);

        return user;

    }
}
