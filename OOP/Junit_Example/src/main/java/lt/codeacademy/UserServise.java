package lt.codeacademy;

import java.util.UUID;

public class UserServise {

    public String getUserName() {
        return "dummyUserName";
    }

    public User getUserById(UUID id) {
        return new User(5);
    }
}
