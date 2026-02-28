package com.raj.khatri.userservice.currentUserDTO;

public class CurrentUserDTO {

    private String userName;
    private String email;


    public CurrentUserDTO(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }


}
