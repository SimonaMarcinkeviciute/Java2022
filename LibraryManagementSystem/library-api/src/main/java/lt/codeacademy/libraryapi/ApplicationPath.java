package lt.codeacademy.libraryapi;

public interface ApplicationPath {
    String bookId = "bookId";
    String itemId = "itemId";
    String rate = "rate";
    String input = "input";
    String userName = "userName";
    String commentId = "commentId";
    String transactionId = "transactionId";
    String fileId = "fileId";


    //paths
    String BOOKS = "/books";
    String BOOK =  "/{" + bookId + "}";
    String UPDATE_BOOK = "/update" + "/{" + bookId + "}" + "/{" + fileId + "}";
    String SEARCH = "/search" + "/{" + input + "}";
    String FILES = "/files";
    String METADATA = "/metadata";
    String UPDATE_FILE = METADATA + "/{" + fileId + "}";
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
    String RETURN_TRANSACTION = "return" + "/{" + transactionId + "}";
    String RATINGS = "/ratings";
    String RATING = BOOK + "/{" + rate + "}";
    String LOGIN = "/login";
    String USER_NAME = USERS_REGISTRATION + "/{" + userName + "}";
}
