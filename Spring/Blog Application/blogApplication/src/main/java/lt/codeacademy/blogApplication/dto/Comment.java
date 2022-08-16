package lt.codeacademy.blogApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.entity.ArticleEntity;
import lt.codeacademy.blogApplication.entity.CommentEntity;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Comment {
    private UUID id;
    @NotBlank
    private String text;
    Article article;



    public static Comment convert(CommentEntity entity) {
        return new Comment(entity.getId(),
                entity.getText(), Article.convert(entity.getArticleEntity()));
    }

    public Comment(UUID id, String text) {
        this.id = id;
        this.text = text;
    }
}
