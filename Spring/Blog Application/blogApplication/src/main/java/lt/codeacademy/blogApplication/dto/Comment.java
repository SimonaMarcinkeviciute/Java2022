package lt.codeacademy.blogApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.entity.ArticleEntity;
import lt.codeacademy.blogApplication.entity.CommentEntity;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private UUID id;
    private String text;

    public static Comment convert(CommentEntity entity) {
        return new Comment(entity.getId(),
                entity.getText());
    }
}
