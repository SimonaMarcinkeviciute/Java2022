package lt.codeacademy.libraryapi;

public interface ApplicationPath {
    String bookId = "bookId";

    //paths
    String ROOT = "/api";
    String BOOKS = ROOT + "/books";
    String BOOK =  "/{" + bookId + "}";
    String SEARCH = "/search";
}
