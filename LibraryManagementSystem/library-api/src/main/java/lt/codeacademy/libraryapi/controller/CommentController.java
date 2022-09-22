package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Comment;
import lt.codeacademy.libraryapi.service.BookService;
import lt.codeacademy.libraryapi.service.CommentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;
import static lt.codeacademy.libraryapi.ApplicationPath.bookId;

@RestController
@RequestMapping(COMMENTS)
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
        return  commentService.findCommentsByBook(book);
    }
}
