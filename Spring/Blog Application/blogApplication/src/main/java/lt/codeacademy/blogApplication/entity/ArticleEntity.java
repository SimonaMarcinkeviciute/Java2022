package lt.codeacademy.blogApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.dto.Article;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class ArticleEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String title;
    private String image;
    private String content;
    private LocalDate date;

    public static ArticleEntity convert(Article article) {
        return new ArticleEntity(article.getId(),
                article.getTitle(),
                article.getImage(),
                article.getContent(),
                article.getDate());
    }

    public ArticleEntity(UUID id, String title, String image, String content) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
    }
}
