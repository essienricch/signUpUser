package semicolon.signinsignout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.signinsignout.data.model.User;

import semicolon.signinsignout.data.repositories.UserRepository;
import semicolon.signinsignout.dtos.requests.*;

import semicolon.signinsignout.dtos.responses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.signinsignout.exceptions.IllegalUserQueryException;
import semicolon.signinsignout.exceptions.IllegalUserRegisterArgument;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {


    @Autowired
    private UserService userService;



    @Test
    void createNewUser_countIsOneTest() throws IllegalUserRegisterArgument {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("kenny");
        registerRequest.setLastName("rogers");
        registerRequest.setEmailAddress("kenroggy123");
        registerRequest.setPhoneNumber("908070");
        registerRequest.setPassword("tetris");
       RegisterResponse registerResponse =  userService.createUser(registerRequest);
        assertEquals(registerResponse.getEmailAddress(),"kenroggy123");

    }

    @Test
    void loginUserTest() throws  IllegalUserQueryException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmailAddress("kenroggy123");
        loginRequest.setPassword("tetris");
        User  savedUser = userService.loginUser(loginRequest);
        assertEquals("kenroggy123", savedUser.getEmailAddress());
    }

    @Test
    void findSavedUserTest() throws IllegalUserQueryException {
       User user = userService.findUserById("kenroggy123");

       assertEquals("kenroggy123",user.getEmailAddress());
       assertNotNull(user.getFirstName());
    }

    @Test
    void updateUserTest() throws IllegalUserQueryException {
        UpdateRequest updateRequest = new UpdateRequest();

        updateRequest.setEmailAddress("kenroggy123");
        updateRequest.setFirstName("joey");
        updateRequest.setPassword("catch");
        UpdateResponse  updateResponse = userService.updateUser(updateRequest);
       assertEquals(updateResponse.getEmailAddress(),updateRequest.getEmailAddress());
       assertEquals(1L, userService.count());
    }

    @Test
    void resetUserPasswordTest() throws IllegalUserQueryException {
        ResetRequest resetRequest = new ResetRequest();
        resetRequest.setEmailAddress("kenroggy123");
        resetRequest.setOldPassword("catch");
        resetRequest.setNewPassword("tetris");
       ResetResponse resetResponse = userService.resetPassword(resetRequest);

        assertNotNull(resetResponse.getEmailAddress());
    }

    @Test
    void deleteUserTest() throws IllegalUserQueryException {
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setEmailAddress("kenroggy123");
        DeleteResponse deleteResponse = userService.deleteUser(deleteRequest);

        assertNotNull(deleteResponse.getEmailAddress());
        assertEquals(0L, userService.count());
    }

}