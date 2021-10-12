package com.webdev.truckmanagementsystem.Users.User.Application.Login;

import java.util.HashMap;

public class UserLoginResponse {

    private final String userName;
    private final String token;

    public UserLoginResponse(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("userName", userName);
        data.put("token", token);
        return data;
    }
}
