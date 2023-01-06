package semicolon.signinsignout.services;

import semicolon.signinsignout.data.model.Human;
import semicolon.signinsignout.dtos.requests.*;
import semicolon.signinsignout.dtos.responses.DeleteResponse;
import semicolon.signinsignout.dtos.responses.RegisterResponse;
import semicolon.signinsignout.dtos.responses.ResetResponse;
import semicolon.signinsignout.dtos.responses.UpdateResponse;
import semicolon.signinsignout.exceptions.IllegalUserQueryException;
import semicolon.signinsignout.exceptions.IllegalUserRegisterArgument;

import java.util.List;

public interface UserService {

    RegisterResponse createUser(RegisterRequest registerRequest) throws IllegalUserRegisterArgument;
    Human loginUser(LoginRequest loginRequest) throws IllegalUserQueryException;

    UpdateResponse updateUser(UpdateRequest updateRequest) throws IllegalUserQueryException;

    ResetResponse resetPassword(ResetRequest resetRequest) throws IllegalUserQueryException;

    DeleteResponse deleteUser(DeleteRequest deleteRequest) throws IllegalUserQueryException;

    List <Human> findAllUser();

    long count();

    Human findUserById(String emailAddress) throws IllegalUserQueryException;

}
