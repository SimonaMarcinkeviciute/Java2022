package lt.codeacademy.libraryapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.dto.Rating;
import lt.codeacademy.libraryapi.dto.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings")
public class RatingEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private int rate;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public static RatingEntity convert(Rating rating)  {

        return new RatingEntity(rating.getId(),
                rating.getRate(),
                BookEntity.convert(rating.getBook()),
                UserEntity.convert(rating.getUser()));
    }
}
