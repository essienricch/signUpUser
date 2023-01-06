package dtos.requests;

public class ResetRequest {

    private String password;
    private String emailAddress;

    public ResetRequest(String password,  String emailAddress) {
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }


    public String getEmailAddress() {
        return emailAddress;
    }
}
