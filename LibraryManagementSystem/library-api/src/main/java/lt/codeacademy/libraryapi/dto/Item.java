package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.entity.ItemEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private UUID id;
    private Status status;
    private Book book;
    private LocalDateTime date;

    public static Item convert(ItemEntity entity) {

        return new Item(entity.getId(),
                entity.getStatus(),
                Book.convert(entity.getBookEntity()),
                entity.getDate()
                );
    }
}
