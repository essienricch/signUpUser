package dtos.requests;

public class UpdateRequest {

    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;

    public UpdateRequest( String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

    }

    public UpdateRequest(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getPhoneNumber() {
        return phoneNumber;
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

    public String getPassword() {
        return password;
    }
}
