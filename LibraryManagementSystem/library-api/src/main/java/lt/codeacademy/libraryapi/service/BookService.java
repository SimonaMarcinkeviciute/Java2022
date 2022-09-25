package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.exception.BookNotExistException;
import lt.codeacademy.libraryapi.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class BookService
{

    private final BookRepository bookRepository;
    private final FileService fileService;

    public BookService(BookRepository bookRepository, FileService fileService) {
        this.bookRepository = bookRepository;
        this.fileService = fileService;
    }

    public Book createBook(Book book) {
        BookEntity bookEntity = bookRepository.save(BookEntity.convert(book));
        return Book.convert(bookEntity);


    }

    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(Book::convert);
    }

    public List<Book> getBooks() throws FileNotFoundException {
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

    public void updateBook(Book book) {
        bookRepository.save(BookEntity.convert(book));
    }

    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }

    public List<Book> search(String query) {

        query = "%" + query + "%";

        return bookRepository.findByTitleLikeOrDescriptionLike(query, query)
                .stream()
                .map(Book::convert)
                .toList();
    }

    public Book findById (UUID id) {
        return bookRepository.findById(id).map(Book::convert).orElseThrow();

    }

}
