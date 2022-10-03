package lt.codeacademy.libraryapi.repository;

import lt.codeacademy.libraryapi.data.TransactionStatus;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.ItemEntity;
import lt.codeacademy.libraryapi.entity.TransactionEntity;
import lt.codeacademy.libraryapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

    List<TransactionEntity> findByUserEntity (UserEntity userEntity);

    List<TransactionEntity> findByItemEntity (ItemEntity item);



}
