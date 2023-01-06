package dtos.responses;

public class ResetResponse {

    private String emailAddress;
    private String resetMessage;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getResetMessage() {
        return resetMessage;
    }

    public void setResetMessage(String resetMessage) {
        this.resetMessage = resetMessage;
    }
}
