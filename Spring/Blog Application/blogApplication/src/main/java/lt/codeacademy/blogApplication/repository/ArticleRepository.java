package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
    List<ArticleEntity> findAllByTitle(String title);

    @Query("SELECT a FROM ArticleEntity a WHERE a.title = :title AND a.date = :date")
    List<ArticleEntity> getArticlesByTitleAndDate(@Param("title") String title, @Param("date") String date);
}
