package lt.codeacademy.libraryapi.repository;


import lt.codeacademy.libraryapi.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
    List<BookEntity> findByTitleLikeIgnoreCaseOrAuthorLikeIgnoreCase(String title, String author);

}