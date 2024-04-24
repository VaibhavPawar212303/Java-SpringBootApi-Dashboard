package com.example.dto;

import com.example.entities.User;

public class LoginResponse {
    private User user;
   // private String token;

    // Constructors, getters, and setters
    public LoginResponse() {
    }

    public LoginResponse(User user) {
        this.user = user;
       // this.token = token;
    }

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
}
