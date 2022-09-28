package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.service.BookService;
import lt.codeacademy.libraryapi.service.RatingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

@RestController
@RequestMapping(RATINGS)
@Api(tags = "Library rating controller")
public class RatingController {

    private final RatingService ratingService;
    private final BookService bookService;

    public RatingController(RatingService ratingService, BookService bookService) {
        this.ratingService = ratingService;
        this.bookService = bookService;
    }

   @GetMapping(value = RATING, produces = MediaType.APPLICATION_JSON_VALUE)
    public long rating (@PathVariable(bookId) UUID id, @PathVariable(rate) int number){

        return ratingService.addRating(number, id);
    }

    @GetMapping(value = BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
    public long getRating (@PathVariable(bookId) UUID id){
        Book book = bookService.getBook(id);
        long i =ratingService.countRatingByBook(book);

        return i;
    }
}
