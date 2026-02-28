package com.raj.khatri.userservice.uerFetchService;

import com.raj.khatri.userservice.userDTO.UserWrapper;
import com.raj.khatri.userservice.userLoginDTO.UserLoginDTO;
import com.raj.khatri.userservice.userRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserFetchService {

    @Autowired
    UserRepo userRepo;

    public UserLoginDTO verifyUserCredentials(String userName) {

        return userRepo.verifyUserCredentials(userName);


    }

    public UserWrapper getUserDetails(String username)
    {
        return userRepo.findUserByUserName(username);
    }


}
