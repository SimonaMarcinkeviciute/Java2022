package lt.codeacademy.libraryapi.exception;

import java.util.UUID;

public class UserNotExistException extends RuntimeException{

    private final String userName;

    public UserNotExistException(String userName) {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
}
