package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.entity.ArticleEntity;
import lt.codeacademy.blogApplication.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
    Page<CommentEntity> findByArticleEntity(ArticleEntity articleEntity, Pageable pageable);
}
