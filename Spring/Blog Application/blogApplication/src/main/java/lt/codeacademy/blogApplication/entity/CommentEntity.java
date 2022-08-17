package lt.codeacademy.blogApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.dto.Comment;
import org.hibernate.annotations.Type;
import org.springframework.web.bind.annotation.Mapping;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="article_id")
    private ArticleEntity articleEntity;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
