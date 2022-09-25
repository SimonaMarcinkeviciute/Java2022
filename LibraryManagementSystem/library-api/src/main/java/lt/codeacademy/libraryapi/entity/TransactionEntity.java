package lt.codeacademy.libraryapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.data.TransactionStatus;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.dto.Item;
import lt.codeacademy.libraryapi.dto.Transaction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private TransactionStatus transactionStatus;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;
    private LocalDate localDate;

    public static TransactionEntity convert(Transaction transaction)  {

        return new TransactionEntity(transaction.getId(),
                transaction.getTransactionStatus(),
                ItemEntity.convert(transaction.getItem()),
                transaction.getLocalDate());
    }
}
