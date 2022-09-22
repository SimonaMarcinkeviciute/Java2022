package lt.codeacademy.libraryapi;

public interface ApplicationPath {
    String bookId = "bookId";
    String FILE_NAME = "fileName";
    String ID = "id";

    //paths
    String ROOT = "/api";
    String BOOKS = ROOT + "/books";
    String BOOK =  "/{" + bookId + "}";
    String SEARCH = "/search";
    String FILES = ROOT + "/files";
    String METADATA = "/metadata";
    String FILE_METADATA = METADATA + "/{" + ID + "}";
    String FILE = "/{" + FILE_NAME + "}";
    String FILE_OBJECT = "/object" + "/{" + ID + "}";
    String COMMENT = "/{" + bookId + "}";
    String COMMENTS = ROOT + "/comments";
    String USERS = ROOT + "/users";
    String USERSREGISTRATION = "/registration";

}
