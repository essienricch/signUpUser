package dtos.responses;

public class LoginResponse {

    private String firstName;

    private String emailAddress;
    private String messageReport;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String setMessageReport(String messageReport) {
        this.messageReport = messageReport;
        return this.messageReport;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }
}
