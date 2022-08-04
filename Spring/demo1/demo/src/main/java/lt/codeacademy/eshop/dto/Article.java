package lt.codeacademy.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.eshop.entity.ArticleEntity;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private UUID id;
    private String title;
    private String content;
    private String date;
    private String author;

    public static Article convert(ArticleEntity entity) {
        return new Article(entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getDate(),
                entity.getAuthor());
    }
}
