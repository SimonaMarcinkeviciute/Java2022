package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
    List<ArticleEntity> findAllByAuthor(String author);
}
