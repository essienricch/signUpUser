package semicolon.signinsignout.data.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Document
public class User {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;
    @NonNull
    @Id
    private String emailAddress;
    @Getter
    @NonNull
    private String password;

    private String phoneNumber;


}
