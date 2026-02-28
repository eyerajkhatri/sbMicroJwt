package com.raj.khatri.userservice.userController;


import com.raj.khatri.userservice.applicationConstants.ApplicationConstants;
import com.raj.khatri.userservice.userEntity.User;
import com.raj.khatri.userservice.userService.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserCreate {

    @Autowired
    UserCreateService userCreateService;


    @PostMapping("/NewUser")
    public String createUser(@RequestBody @Validated User user) {


        int res = userCreateService.createUser(user);

        if (res == 1) {
            return ApplicationConstants.userCreated;
        } else {
            return ApplicationConstants.userNameOrEmailExists;
        }

    }


}
