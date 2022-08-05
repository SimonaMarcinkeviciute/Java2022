package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
    List<ArticleEntity> findAllByAuthor(String author);

    @Query("SELECT a FROM ArticleEntity a WHERE a.author = :author AND a.date = :date")
    List<ArticleEntity> getArticlesByAuthorAndDate(@Param("author") String author, @Param("date") String date);
}
