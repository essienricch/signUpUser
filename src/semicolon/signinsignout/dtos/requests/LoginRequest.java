package dtos.requests;

public class LoginRequest {

    private String emailAddress;
    private String password;

    private String  confirmPassword;

    public LoginRequest(String emailAddress, String password, String confirmPassword) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public LoginRequest(){

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
