package lt.codeacademy.libraryapi.repository;

import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {

    List<CommentEntity> findByBookEntity(BookEntity bookEntity);
}
