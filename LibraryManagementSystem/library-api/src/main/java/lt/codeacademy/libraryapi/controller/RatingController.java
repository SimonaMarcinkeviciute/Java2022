package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.service.BookService;
import lt.codeacademy.libraryapi.service.RatingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @ApiOperation(value = "Add book rating", tags = "addRating", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ratings returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
   @GetMapping(value = RATING, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Long> rating (@PathVariable(bookId) UUID id, @PathVariable(rate) int number, Principal principal){

        return ratingService.addRating(number, id, principal);
    }

    @ApiOperation(value = "Get book rating", tags = "getRating", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Items returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Long> getRating (@PathVariable(bookId) UUID id){
        Book book = bookService.getBook(id);

        return ratingService.countRatingByBook(book);
    }



}
