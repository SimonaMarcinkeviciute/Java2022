package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Comment;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.CommentEntity;
import lt.codeacademy.libraryapi.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BookService bookService;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, BookService bookService, UserService userService) {
        this.commentRepository = commentRepository;
        this.bookService = bookService;
        this.userService = userService;
    }

    public List<Comment> findCommentsByBook(Book book) {
        BookEntity bookEntity = BookEntity.convert(book);

        return commentRepository.findByBookEntity(bookEntity).stream().map(Comment::convert).toList();
    }

    public List<Comment> createComment(UUID bookId, Comment comment, Principal principal) {
        Book book = bookService.findById(bookId);
        comment.setBook(book);
        comment.setDate(LocalDate.now());

        User user = (User) userService.loadUserByUsername(principal.getName());
        comment.setUser(user);

        return  findCommentsByBook(book);
    }

    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }
}
