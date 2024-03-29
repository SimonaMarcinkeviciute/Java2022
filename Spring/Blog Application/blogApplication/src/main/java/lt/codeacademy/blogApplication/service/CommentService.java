package lt.codeacademy.blogApplication.service;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.dto.Comment;
import lt.codeacademy.blogApplication.entity.ArticleEntity;
import lt.codeacademy.blogApplication.entity.CommentEntity;
import lt.codeacademy.blogApplication.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(Comment comment) {
        commentRepository.save(CommentEntity.convert(comment));
    }

    public Page<Comment> find(Article article, Pageable pageable) {
        ArticleEntity articleEntity = ArticleEntity.convert(article);

        return commentRepository.findByArticleEntity(articleEntity, pageable).map(Comment::convert);
    }

    public void delete(UUID id) {
        commentRepository.deleteById(id);
    }

    public Comment getComment(UUID id) {
        return commentRepository.findById(id).map(Comment::convert).orElseThrow();
    }
}
