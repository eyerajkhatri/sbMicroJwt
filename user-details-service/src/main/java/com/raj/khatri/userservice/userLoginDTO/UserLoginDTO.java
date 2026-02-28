package com.raj.khatri.userservice.userLoginDTO;

public class UserLoginDTO {

    private String userName;
    private String password;

    public UserLoginDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
