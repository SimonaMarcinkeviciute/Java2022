package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.data.TransactionStatus;
import lt.codeacademy.libraryapi.entity.TransactionEntity;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private UUID id;
    private TransactionStatus transactionStatus;
    private Item item;
    private LocalDate localDate;
    private User user;

    public static Transaction convert(TransactionEntity entity)  {

        return new Transaction(entity.getId(),
                entity.getTransactionStatus(),
                Item.convert(entity.getItemEntity()),
                entity.getLocalDate(),
                User.convert(entity.getUserEntity()));
    }
}
