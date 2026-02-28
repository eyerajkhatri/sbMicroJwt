package com.raj.khatri.userservice.queryConstants;

public class QueryConstants {

    public static final String verifyUserCredentials = "select new "
            + "com.raj.khatri.userservice.userLoginDTO.UserLoginDTO(u.userName, u.password) "
            + "from User u "
            + "where u.userName = :userName";

    public static final String checkUserExists = "select new "
            + "com.raj.khatri.userservice.currentUserDTO.CurrentUserDTO(u.userName, u.email) "
            + "from User u "
            + "where u.userName = :userName or u.email = :email";


    public static final String findUserByUserName = "select new "
            + "com.raj.khatri.userservice.userDTO.UserWrapper(u.userName, u.firstName, u.lastName, u.email) "
            + "from User u "
            + "where u.userName = :username";


}
