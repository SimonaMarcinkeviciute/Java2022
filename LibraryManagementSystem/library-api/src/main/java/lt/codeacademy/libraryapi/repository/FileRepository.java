package lt.codeacademy.libraryapi.repository;


import lt.codeacademy.libraryapi.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository extends JpaRepository<FileEntity, UUID> {
}