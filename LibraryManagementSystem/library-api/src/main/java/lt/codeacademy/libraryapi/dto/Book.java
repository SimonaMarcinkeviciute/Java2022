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
public class Book
{
    private UUID id;
    private String img;
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
    private String ISBN;

    //komentaras
    //ivertinimas



    public static Book convert(BookEntity entity) {
        return new Book(entity.getId(),
                entity.getImg(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getDescription(),
                entity.getGenre(),
                entity.getPages(),
                entity.getLanguage(),
                entity.getFirstPublication(),
                entity.getPublication(),
                entity.getPublisher(),
                entity.getISBN());
    }
}