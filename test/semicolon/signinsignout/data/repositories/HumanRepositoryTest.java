package semicolon.signinsignout.data.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.signinsignout.data.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserTest_countIsOneTest(){
        User user = new User("spycy","frsh","tessy908","wombolo","44567");
        userRepository.save(user);

        assertEquals(1L, userRepository.count());
    }

}