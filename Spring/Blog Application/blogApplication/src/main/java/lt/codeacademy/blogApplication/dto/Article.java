package lt.codeacademy.blogApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.entity.ArticleEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private UUID id;
    @NotBlank
    @Size(min = 5, max = 50, message = "{validation.article.size}")
    private String title;
    @Size(max = 500)
    @NotBlank
    private String image;
    @NotBlank
    @Size(min=1, max = 2000, message = "{validation.article.size}")
    private String content;
    private LocalDate date;

    public static Article convert(ArticleEntity entity) {

        return new Article(entity.getId(),
                entity.getTitle(),
                entity.getImage(),
                entity.getContent(),
                entity.getDate());
    }
}
