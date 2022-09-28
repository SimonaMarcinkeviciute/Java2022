package lt.codeacademy.libraryapi;

public interface ApplicationPath {
    String bookId = "bookId";
    String FILE_NAME = "fileName";
    String ID = "id";
    String itemId = "itemId";
    String rate = "rate";
    String input = "input";
    String userName = "userName";

    //paths
    String BOOKS = "/books";
    String BOOK =  "/{" + bookId + "}";
    String SEARCH = "/search" + "/{" + input + "}";
    String FILES = "/files";
    String METADATA = "/metadata";
    String FILE_METADATA = METADATA + "/{" + ID + "}";
    String FILE = "/{" + FILE_NAME + "}";
    String FILE_OBJECT = "/object" + "/{" + ID + "}";
    String COMMENTS = "/comments";

    String COMMENT = "/comments" + "/{" + bookId + "}";
    String USERS = "/users";
    String USERS_REGISTRATION = "/registration";

    String CREATE_COMMENT = "/books" + "/{" + bookId + "}" + "/details";

    String ITEMS = "/items";
    String AVAILABLE_ITEMS = "/available" + BOOK;
    String TRANSACTIONS = "/transactions";
    String TRANSACTION = "/{" + itemId + "}";

    String RATINGS = "/ratings";

    String RATING = BOOK + "/{" + rate + "}";

    String LOGIN = "/login";
    String USER_NAME = USERS_REGISTRATION + "/{" + userName + "}";



    //api/items/available/bookid

}
