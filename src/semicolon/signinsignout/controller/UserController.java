package controller;

import dtos.requests.RegisterRequest;
import services.UserServiceImpl;

public class UserController {

    private UserServiceImpl userService;

    public String registerUser(RegisterRequest registerRequest){
        userService.createUser(registerRequest);
        return "Registration Successful";
    }

}
