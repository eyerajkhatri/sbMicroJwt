package com.raj.khatri.userservice.userService;


import com.raj.khatri.userservice.currentUserDTO.CurrentUserDTO;
import com.raj.khatri.userservice.userEntity.User;
import com.raj.khatri.userservice.userRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserCreateService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    public int createUser(User user) {

        int res = 0;

        CurrentUserDTO currentUserDTO = userRepo.checkUserExists(user.getUserName(), user.getEmail());


        if (currentUserDTO == null) {

            User u = new User();

            u.setUserName(user.getUserName());
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setPassword(Objects.requireNonNull(passwordEncoder.encode(user.getPassword())));
            userRepo.save(u);


            res = 1;

            return res;

        } else {

            return res;

        }

    }


}


