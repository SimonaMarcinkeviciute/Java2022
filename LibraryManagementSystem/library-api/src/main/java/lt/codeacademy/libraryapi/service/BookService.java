package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.*;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.exception.BookNotExistException;
import lt.codeacademy.libraryapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        BookEntity bookEntity = bookRepository.save(BookEntity.convert(book));

        return Book.convert(bookEntity);
    }

    public List<Book> getBooks() {

        return bookRepository.findAll()
                .stream()
                .map(Book::convert)
                .toList();
    }

    public Book getBook(UUID id) {

        return bookRepository.findById(id)
                .map(Book::convert)
                .orElseThrow(() -> new BookNotExistException(id));
    }

    public Book updateBook(Book book) {
        BookEntity bookEntity = bookRepository.save(BookEntity.convert(book));
        return Book.convert(bookEntity);
    }

    public List<Book> search(String query) {

        query = "%" + query + "%";

        return bookRepository.findByTitleLikeIgnoreCaseOrAuthorLikeIgnoreCase(query, query)
                .stream()
                .map(Book::convert)
                .toList();
    }

    public Book findById (UUID id) {

        return bookRepository.findById(id).map(Book::convert).orElseThrow();
    }
}
