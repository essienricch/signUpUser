package semicolon.signinsignout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.signinsignout.data.model.Human;
import semicolon.signinsignout.data.repositories.UserRepository;
import semicolon.signinsignout.dtos.requests.*;
import semicolon.signinsignout.dtos.responses.*;
import semicolon.signinsignout.exceptions.IllegalUserQueryException;
import semicolon.signinsignout.exceptions.IllegalUserRegisterArgument;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
   private UserRepository userRepository;

    @Override
    public RegisterResponse createUser(RegisterRequest registerRequest) throws IllegalUserRegisterArgument {

        if (matchingPassword(registerRequest)) {
            if (!userRepository.existsById(registerRequest.getEmailAddress())) {
                Human human = new Human();
                human.setFirstName(registerRequest.getFirstName());
                human.setLastName(registerRequest.getLastName());
                human.setEmailAddress(registerRequest.getEmailAddress());
                human.setPassword(registerRequest.getPassword());
                human.setPhoneNumber(registerRequest.getPhoneNumber());
                userRepository.save(human);
                RegisterResponse registerResponse = new RegisterResponse();
                registerResponse.setMessage("Sign up Successful");
                registerResponse.setEmailAddress(human.getEmailAddress());
                return registerResponse;
            } else System.out.println("User exist already");
        }else throw new  IllegalUserRegisterArgument("Password doesn't match");
        return null;
    }

    private boolean matchingPassword(RegisterRequest registerRequest){
        return registerRequest.getPassword().equals(registerRequest.getConfirmPassword());
    }

    @Override
    public Human loginUser(LoginRequest loginRequest) throws  IllegalUserQueryException {
        LoginResponse loginResponse = new LoginResponse();

        if (confirmLoginUser(loginRequest)){
            Human savedHuman = findUserById(loginResponse.getEmailAddress());
            if (savedHuman != null) {
                loginResponse.setEmailAddress(loginResponse.getEmailAddress());
                loginResponse.setMessageReport("Login successful");
                return savedHuman;
            } else throw new IllegalUserQueryException("Human not found");
        }return null;
    }

    @Override
    public UpdateResponse updateUser(UpdateRequest updateRequest) throws IllegalUserQueryException {
        UpdateResponse updateResponse = new UpdateResponse();

        Human updateHuman = findUserById(updateRequest.getEmailAddress());

        if (updateHuman != null){
           updateHuman.setFirstName(updateRequest.getFirstName());
           updateHuman.setLastName(updateRequest.getLastName());
           updateHuman.setPhoneNumber(updateRequest.getPhoneNumber());
           updateHuman.setPassword(updateRequest.getPassword());
           userRepository.save(updateHuman);
            updateResponse.setUpdateMessage(" Update Successful");
            updateResponse.setEmailAddress(updateHuman.getEmailAddress());
            return updateResponse;
        }
        return null;
    }

    @Override
    public ResetResponse resetPassword(ResetRequest resetRequest) throws IllegalUserQueryException {
        ResetResponse resetResponse = new ResetResponse();

        if (confirmExistingPass(resetRequest)){
            resetResponse.setResetMessage(" Password Reset Successful ");
            resetResponse.setEmailAddress(resetRequest.getEmailAddress());
            return resetResponse;
        }else {
            throw new IllegalUserQueryException("Incorrect Password");
        }
    }

    private boolean confirmExistingPass(ResetRequest resetRequest) throws IllegalUserQueryException {
        Human human = findUserById(resetRequest.getEmailAddress());
        if (human.getPassword().equals(resetRequest.getOldPassword())){
            human.setPassword(resetRequest.getNewPassword());
            userRepository.save(human);
            return true;
        }return false;
    }

    private boolean confirmLoginUser(LoginRequest loginRequest) throws IllegalUserQueryException {
        Human savedHuman = findUserById(loginRequest.getEmailAddress());
        if (savedHuman != null) {
            return savedHuman.getPassword().equals(loginRequest.getPassword());
        }else throw new IllegalUserQueryException("Human Not Found");
    }


    @Override
    public DeleteResponse deleteUser(DeleteRequest deleteRequest) throws IllegalUserQueryException {
        DeleteResponse deleteResponse = new DeleteResponse();
        Human human = findUserById(deleteRequest.getEmailAddress());
            if (human != null){
                userRepository.delete(human);
                deleteResponse.setEmailAddress(deleteRequest.getEmailAddress());
                deleteResponse.setMessageReport("Delete Successful");
                System.out.println(deleteResponse.getMessageReport());
                return deleteResponse;

            }else throw new IllegalUserQueryException("Human doesn't exist");
    }

    @Override
    public List<Human> findAllUser() {
        return userRepository.findAll();
    }

    public Human findUserById(String emailAddress) throws IllegalUserQueryException {
        for (Human human : findAllUser()){
            if (human.getEmailAddress().equals(emailAddress)){
                return human;
            }else throw new IllegalUserQueryException("Human not found");
        }return null;
    }

    @Override
    public long count() {
        return userRepository.count();
    }
}
