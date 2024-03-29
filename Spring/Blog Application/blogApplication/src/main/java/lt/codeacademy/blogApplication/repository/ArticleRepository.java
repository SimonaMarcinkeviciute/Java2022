package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {

}
