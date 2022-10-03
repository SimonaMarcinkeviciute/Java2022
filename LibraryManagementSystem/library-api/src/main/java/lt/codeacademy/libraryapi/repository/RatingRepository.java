package lt.codeacademy.libraryapi.repository;

import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.RatingEntity;
import lt.codeacademy.libraryapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RatingRepository extends JpaRepository<RatingEntity, UUID> {

    long countRateByBookEntity(BookEntity book);

    List<RatingEntity> findByBookEntity (BookEntity book);
    RatingEntity findByBookEntityAndAndUserEntity(BookEntity book, UserEntity user);
}
