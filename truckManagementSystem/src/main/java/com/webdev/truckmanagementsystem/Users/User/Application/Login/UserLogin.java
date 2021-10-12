package com.webdev.truckmanagementsystem.Users.User.Application.Login;

import com.webdev.truckmanagementsystem.Shared.Application.TokenGeneration;
import com.webdev.truckmanagementsystem.Shared.Application.TokenGenerationResponse;

public class UserLogin {

    private final TokenGeneration tokenGeneration;

    public UserLogin(TokenGeneration tokenGeneration) {
        this.tokenGeneration = tokenGeneration;
    }

    public UserLoginResponse execute(String username, String password) {
        //Validar que el usuario exista
        //Comprobar que la contraseña es correcta
        TokenGenerationResponse responseToken = this.tokenGeneration.execute(username);
        UserLoginResponse response = new UserLoginResponse(username, responseToken.token());
        return response;
    }

}
