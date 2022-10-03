package lt.codeacademy.libraryapi.repository;

import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.FileEntity;
import lt.codeacademy.libraryapi.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    List<ItemEntity> findByStatusAndBookEntity(Status status, BookEntity book);

    List<ItemEntity> findByBookEntity(BookEntity book);
}
