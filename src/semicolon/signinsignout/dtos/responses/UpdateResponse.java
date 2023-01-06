package dtos.responses;

public class UpdateResponse {

    private String emailAddress;
    private String updateMessage;

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
