package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.entity.BookEntity;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private UUID id;
    private String fileId;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String description;
    @NotBlank
    private String genre;
    @NotBlank
    private int pages;
    @NotBlank
    private String language;
    @NotBlank
    private LocalDate firstPublication;
    @NotBlank
    private LocalDate publication;
    @NotBlank
    private String publisher;
    @NotBlank
    private String isbn;
    private int quantity;
    @NotBlank
    private File file;

    public static Book convert(BookEntity entity) {

        return new Book(entity.getId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getDescription(),
                entity.getGenre(),
                entity.getPages(),
                entity.getLanguage(),
                entity.getFirstPublication(),
                entity.getPublication(),
                entity.getPublisher(),
                entity.getIsbn(),
                File.convert(entity.getFileEntity()));
    }

    public Book(UUID id, String title, String author, String description, String genre, int pages, String language, LocalDate firstPublication, LocalDate publication, String publisher, String isbn, File file) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.pages = pages;
        this.language = language;
        this.firstPublication = firstPublication;
        this.publication = publication;
        this.publisher = publisher;
        this.isbn = isbn;
        this.file = file;
    }
}