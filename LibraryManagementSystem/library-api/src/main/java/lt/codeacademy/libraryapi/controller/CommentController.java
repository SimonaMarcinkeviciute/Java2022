package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.AuthorizationScope;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Comment;
import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.service.BookService;
import lt.codeacademy.libraryapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.security.Principal;
import java.time.LocalDate;
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

    @GetMapping(value = COMMENT, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getComments(@PathVariable(bookId) UUID id) {
        Book book = bookService.getBook(id);
        return commentService.findCommentsByBook(book);
    }

    @PostMapping(value = CREATE_COMMENT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)//201
    //requestBody, kad galetume paduoti book, sumapintu paduotum duomenis su siuo objektu
    public List<Comment> createComment(@RequestBody Comment comment, @PathVariable(bookId) UUID id, Principal principal) {

       return commentService.createComment(id, comment, principal);
    }

    @DeleteMapping(value = DELETE_COMMENTS)
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    public void deleteComment(@PathVariable(commentId) UUID id) {
        commentService.deleteComment(id);
    }
}
