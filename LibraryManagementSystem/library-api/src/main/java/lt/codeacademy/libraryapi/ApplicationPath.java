package lt.codeacademy.libraryapi;

public interface ApplicationPath {
    String bookId = "bookId";
    String FILE_NAME = "fileName";
    String ID = "id";
    String itemId = "itemId";

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
    String COMMENTS = ROOT + "/comments";

    String COMMENT = "/comments" + "/{" + bookId + "}";
    String USERS = ROOT + "/users";
    String USERS_REGISTRATION = "/registration";

    String CREATE_COMMENT = "/books" + "/{" + bookId + "}" + "/details";

    String ITEMS = ROOT + "/items";
    String AVAILABLE_ITEMS = "/available" + BOOK;
    String TRANSACTIONS = ROOT + "/transactions";
    String TRANSACTION = "/{" + itemId + "}";


    //api/items/available/bookid

}
