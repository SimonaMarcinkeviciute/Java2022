package lt.codeacademy.eshopapi.repository;

import lt.codeacademy.eshopapi.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository extends JpaRepository<FileEntity, UUID> {
}
