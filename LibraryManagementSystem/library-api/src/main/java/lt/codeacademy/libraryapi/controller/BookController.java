package lt.codeacademy.libraryapi.controller;

import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

@RestController
@RequestMapping(BOOKS)
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(value = BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable(bookId) UUID id) {
        return bookService.getBook(id);
    }
}
