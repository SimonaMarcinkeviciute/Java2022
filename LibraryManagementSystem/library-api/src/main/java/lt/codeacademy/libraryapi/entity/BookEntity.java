package lt.codeacademy.libraryapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.File;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    private String isbn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private FileEntity fileEntity;


    public static BookEntity convert(Book b) {
        File file = b.getFile();
        FileEntity fileEntity1 = FileEntity.convert(file);

        return new BookEntity(
                b.getId(),
                b.getTitle(),
                b.getAuthor(),
                b.getDescription(),
                b.getGenre(),
                b.getPages(),
                b.getLanguage(),
                b.getFirstPublication(),
                b.getPublication(),
                b.getPublisher(),
                b.getIsbn(),
                fileEntity1

        );
    }


}
