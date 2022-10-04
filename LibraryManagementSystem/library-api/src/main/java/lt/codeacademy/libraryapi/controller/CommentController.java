package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Comment;
import lt.codeacademy.libraryapi.service.BookService;
import lt.codeacademy.libraryapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;
import static lt.codeacademy.libraryapi.ApplicationPath.bookId;

@RestController
@RequestMapping()
@Api(tags = "Library comment controller")
public class CommentController {

    private final CommentService commentService;
    private final BookService bookService;

    public CommentController(CommentService commentService, BookService bookService) {
        this.commentService = commentService;
        this.bookService = bookService;
    }

    @ApiOperation(value = "Get all comments by book", tags = "getComments", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All comments returned successfully"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = COMMENT, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getComments(@PathVariable(bookId) UUID id) {
        Book book = bookService.getBook(id);
        return commentService.findCommentsByBook(book);
    }

    @ApiOperation(value = "Create comment", tags = "createComment", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Comment created successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @PostMapping(value = CREATE_COMMENT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)//201
    //requestBody, kad galetume paduoti book, sumapintu paduotum duomenis su siuo objektu
    public List<Comment> createComment(@RequestBody Comment comment, @PathVariable(bookId) UUID id, Principal principal) {

       return commentService.createComment(id, comment, principal);
    }

    @ApiOperation(value = "Delete comment", tags = "deleteComment", httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment deleted successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @DeleteMapping(value = DELETE_COMMENTS)
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    public void deleteComment(@PathVariable(commentId) UUID id) {
        commentService.deleteComment(id);
    }
}
