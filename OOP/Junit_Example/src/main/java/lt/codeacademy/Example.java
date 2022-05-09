package lt.codeacademy;

import java.util.UUID;

public class Example {

    private final UserServise userServise;

    public Example(UserServise userServise) {
        this.userServise = userServise;
    }

    public boolean createNewNumber(User user){
        String userNmae = userServise.getUserName();
        if(user.age > 10 && userNmae != null) {
            return true;
        }
        return false;
    }

    public User getUserById(UUID id) throws IllegalAccessException {
        if(id == null) {
            throw new IllegalAccessException("Missing user id");
        }
        return  userServise.getUserById(id);
    }
}
