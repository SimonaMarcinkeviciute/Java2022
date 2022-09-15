package lt.codeacademy.libraryapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.dto.Book;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity
{
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String img;
    private String title;
    private String author;
    @Column(columnDefinition = "VARCHAR(5000)")
    private String description;
    private String genre;
    private int pages;
    private String language;
    private LocalDate firstPublication;
    private LocalDate publication;
    private String publisher;
    private String ISBN;

    public static BookEntity convert(Book b) {
        return new BookEntity(
                b.getId(),
                b.getImg(),
                b.getTitle(),
                b.getAuthor(),
                b.getDescription(),
                b.getGenre(),
                b.getPages(),
                b.getLanguage(),
                b.getFirstPublication(),
                b.getPublication(),
                b.getPublisher(),
                b.getISBN()
        );
    }
}
