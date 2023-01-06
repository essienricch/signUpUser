package data.repositories;

import data.model.User;

public interface UserRepository {

    void saveUser(User user);

    User updateUserInfo(User user);

    User findById(String emailAddress);

    boolean findIfEmailExists(String emailAddress);
    User delete(User user);
    User delete(String emailAddress);

    int count();

}
