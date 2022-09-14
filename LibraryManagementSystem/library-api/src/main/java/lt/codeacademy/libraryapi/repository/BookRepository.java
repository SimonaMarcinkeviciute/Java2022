package lt.codeacademy.libraryapi.repository;


import lt.codeacademy.libraryapi.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    //naudojam jpa grazinti rezultatui
    List<BookEntity> findByTitleLikeOrDescriptionLike(String name, String description);

}