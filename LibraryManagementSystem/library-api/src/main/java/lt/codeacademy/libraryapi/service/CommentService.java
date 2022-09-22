package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Comment;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.CommentEntity;
import lt.codeacademy.libraryapi.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findCommentsByBook(Book book) {
        BookEntity bookEntity = BookEntity.convert(book);

        return commentRepository.findByBookEntity(bookEntity).stream().map(Comment::convert).toList();
    }
}
