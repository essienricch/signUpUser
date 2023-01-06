package dtos.requests;

public class DeleteRequest {

    private String emailAddress;

    public DeleteRequest(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
