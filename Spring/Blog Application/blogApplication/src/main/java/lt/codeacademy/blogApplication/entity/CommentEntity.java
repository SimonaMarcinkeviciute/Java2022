package lt.codeacademy.blogApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.dto.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String text;
    private LocalDate date;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne()
    @JoinColumn(name="article_id")
    private ArticleEntity articleEntity;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    public static CommentEntity convert(Comment comment) {
        return new CommentEntity(comment.getId(),
                comment.getText(),
                comment.getDate(),
                ArticleEntity.convert(comment.getArticle()),
                UserEntity.convert(comment.getUser()));
    }

    public CommentEntity(UUID id, String text) {
        this.id = id;
        this.text = text;
    }
}
