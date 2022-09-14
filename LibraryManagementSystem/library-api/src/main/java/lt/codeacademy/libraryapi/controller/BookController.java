package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;


@RestController
@RequestMapping(BOOKS)
@Api(tags = "Library book controller")// anotacija ideti kontroleri i swagger, tagas prie ko bus pridetas musu kontroleris
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    //apsirasom savo statusus
    @ApiOperation(value = "Get all library books", tags = "getBooks", httpMethod = "GET")
    //surasom visus responce kurie gali buti sitame rezultate
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All books returned successfully"),
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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)//201
    //requestBody, kad galetume paduoti book, sumapintu paduotum duomenis su siuo objektu
    public void createProduct(@RequestBody Book book) {
        bookService.createBook(book);
    }

    //PutMapping produkto updatinimui
    //
    @PutMapping(value = BOOK, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)//202
    //PathVariable, kad pasiimti book Id is path
    public void updateBook(@RequestBody Book book, @PathVariable(bookId) UUID id) {
        book.setId(id);
        bookService.updateBook(book);
    }

    //nereikalinga nei produce nei consume, nes nieko negrazinsim ir nieko nepriimsim
    @DeleteMapping(value = BOOK)
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    public void deleteBook(@PathVariable(bookId) UUID id) {
       bookService.delete(id);
    }

    //produce grazina
    @GetMapping(value = SEARCH, produces =  MediaType.APPLICATION_JSON_VALUE)
   //request param -
    public List<Book> search(@RequestParam String query) {
        return bookService.search(query);
    }
}
