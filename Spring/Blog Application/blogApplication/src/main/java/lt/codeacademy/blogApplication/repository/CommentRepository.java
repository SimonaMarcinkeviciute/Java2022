package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.dto.Comment;
import lt.codeacademy.blogApplication.entity.ArticleEntity;
import lt.codeacademy.blogApplication.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {

//@Query(value = "SELECT * FROM commentEntity WHERE articleEntity = :articleEntity")
//Page<CommentEntity> (@Param("articleEntity")ArticleEntity articleEntity, Pageable pageable);

    //Page<Comment> findAllByArticleEntity(ArticleEntity articleEntity, Pageable pageable);

    //Page<CommentEntity> findByCommentEntityByArticleEntity(ArticleEntity article, Pageable pageable);

    Page<CommentEntity> findByArticleEntity(ArticleEntity articleEntity, Pageable pageable);


}
