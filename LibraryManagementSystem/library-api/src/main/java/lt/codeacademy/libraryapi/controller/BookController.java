package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.service.BookService;
import lt.codeacademy.libraryapi.service.FileService;
import lt.codeacademy.libraryapi.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;


@RestController
@RequestMapping(BOOKS)
@Api(tags = "Library book controller")
// anotacija ideti kontroleri i swagger, tagas prie ko bus pridetas musu kontroleris
public class BookController {

    private final BookService bookService;
    private final FileService fileService;
    private final ItemService itemService;

    public BookController(BookService bookService, FileService fileService, ItemService itemService) {
        this.bookService = bookService;
        this.fileService = fileService;
        this.itemService = itemService;
    }

    @ApiOperation(value = "Get all library books", tags = "getBooks", httpMethod = "GET")
    //surasom visus responce kurie gali buti sitame rezultate
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All books returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @ApiOperation(value = "Get  books", tags = "getBook", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Books returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable(bookId) UUID id) {
        return bookService.getBook(id);
    }

    //sukurti su postMapping
    //turim nurodyti koki duomenu tipa priimam
    //consume - priima
    //by defoult siuncia narsykle GET
    @ApiOperation(value = "Create book", tags = "saveBook", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book created successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBooks(@RequestBody Book book) throws FileNotFoundException {
        int itemQuantity = book.getQuantity();
        UUID fileId = UUID.fromString(book.getFileId());
        File file = fileService.getFileObjectById(fileId);
        book.setFile(file);
        Book createdBook = bookService.createBook(book);
        createdBook.setFile(file);
        itemService.createItem(createdBook, itemQuantity);


    }

    @ApiOperation(value = "Update book", tags = "updateBook", httpMethod = "PUT")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Books updated successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @PutMapping(value = UPDATE_BOOK, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBook(@RequestBody Book book, @PathVariable(bookId) UUID id, @PathVariable(fileId) UUID idFile) throws FileNotFoundException {
        book.setId(id);
        book.setFile(fileService.getFileObjectById(idFile));
        Book newBook = bookService.updateBook(book);
        itemService.createItem(newBook, book.getQuantity());
    }


    //produce grazina
    @ApiOperation(value = "Get all library books by search", tags = "getBooksBySearch", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All books returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = SEARCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> search(@PathVariable(input) String text) {
        return bookService.search(text);
    }


}
