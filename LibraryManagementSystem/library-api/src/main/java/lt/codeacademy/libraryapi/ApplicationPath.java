package lt.codeacademy.libraryapi;

public interface ApplicationPath {
    String bookId = "bookId";
    String FILE_NAME = "fileName";
    String ID = "id";
    String itemId = "itemId";
    String rate = "rate";
    String input = "input";
    String userName = "userName";
    String commentId = "commentId";
    String transactionId = "transactionId";
    String userId = "userId";

    //paths
    String BOOKS = "/books";
    String BOOK =  "/{" + bookId + "}";
    String SEARCH = "/search" + "/{" + input + "}";
    String FILES = "/files";
    String METADATA = "/metadata";
    String FILE_METADATA = METADATA + "/{" + ID + "}";
    String FILE = "/{" + FILE_NAME + "}";
    String FILE_OBJECT = "/object" + "/{" + ID + "}";
    String DELETE_COMMENTS = "/comments" + "/{" + commentId + "}";



    String COMMENT = "/comments" + "/{" + bookId + "}";
    String USERS = "/users";
    String USERS_REGISTRATION = "/registration";

    String CREATE_COMMENT = "/books" + "/{" + bookId + "}" + "/details";

    String ITEMS = "/items";
    String CHANGE_ITEM_STATUS = "/status" + "/{" + itemId + "}" + "/{" + bookId + "}";
    String ITEMS_BY_BOOK = "/{" + bookId + "}";
    String AVAILABLE_ITEMS = "/available" + BOOK;
    String ISAVAILABLE = "/available" + "/{" + bookId + "}";
    String TRANSACTIONS = "/transactions";
    String TRANSACTION = "/{" + itemId + "}";

    String TRANSACTION_BY_USER = "/byUser";
    String TRANSACTION_BY_BOOK = "/byBook" + "/{" + bookId + "}";

    String RETURN_TRANSACTION = "return" + "/{" + transactionId + "}";

    String RATINGS = "/ratings";

    String RATING = BOOK + "/{" + rate + "}";
    String USER_RATING = "/userRatings" + BOOK + "/{" + userId + "}";;

    String LOGIN = "/login";
    String USER_NAME = USERS_REGISTRATION + "/{" + userName + "}";



    //api/items/available/bookid

}
