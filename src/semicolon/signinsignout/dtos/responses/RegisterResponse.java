package dtos.responses;

public class RegisterResponse {

    private String firstName;
    private String lastName;
    private String emailAddress;

    private String registerReport;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String setRegisterReport(String registerReport) {
        this.registerReport = registerReport;
        return this.registerReport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
