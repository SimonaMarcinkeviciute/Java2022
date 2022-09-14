package lt.codeacademy.libraryapi.exception;

import java.util.UUID;

public class BookNotExistException extends RuntimeException{
    private final UUID bookId;

    public BookNotExistException(UUID bookId) {
        this.bookId = bookId;
    }

    public UUID getBookId()
    {
        return bookId;
    }
}
