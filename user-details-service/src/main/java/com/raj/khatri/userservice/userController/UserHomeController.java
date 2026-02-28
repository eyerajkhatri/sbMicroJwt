package com.raj.khatri.userservice.userController;


import com.raj.khatri.userservice.userDTO.UserWrapper;
import com.raj.khatri.userservice.uerFetchService.UserFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserHomeController {

    @Autowired
    UserFetchService userFetchService;

    @GetMapping("/home")
    public UserWrapper getUserDetails(@RequestParam String username)
    {
        return userFetchService.getUserDetails(username);
    }
}
