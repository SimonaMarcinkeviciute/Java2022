package lt.codeacademy.libraryapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Comment;
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
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    public static CommentEntity convert(Comment comment) {
        return new CommentEntity(
                comment.getId(),
                comment.getText(),
                comment.getDate(),
                BookEntity.convert(comment.getBook())
        );
    }
}
