package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.FileEntity;
import org.hibernate.boot.Metadata;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book
{
    private UUID id;
    private String fileId;

    private String title;

    private String author;

    private String description;

    private String genre;

    private int pages;

    private String language;

    private LocalDate firstPublication;

    private LocalDate publication;

    private String publisher;

    private String isbn;
    private int quantity;
    private File file;




    //komentaras
    //ivertinimas



    public static Book convert(BookEntity entity)  {

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