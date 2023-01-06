package dtos.responses;

public class DeleteResponse {

    private String messageReport;
    private String emailAddress;

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String  setMessageReport(String messageReport) {
        this.messageReport = messageReport;
        return emailAddress + this.messageReport;
    }

    public String getMessageReport() {
        return messageReport;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
