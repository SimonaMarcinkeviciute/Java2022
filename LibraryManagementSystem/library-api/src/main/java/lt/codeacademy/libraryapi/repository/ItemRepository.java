package lt.codeacademy.libraryapi.repository;

import lt.codeacademy.libraryapi.entity.FileEntity;
import lt.codeacademy.libraryapi.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
}
