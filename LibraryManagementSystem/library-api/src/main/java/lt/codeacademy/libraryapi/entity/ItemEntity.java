package lt.codeacademy.libraryapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Item;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
    private LocalDateTime date;

    public static ItemEntity convert(Item item) {

        return new ItemEntity(item.getId(),
                item.getStatus(),
                BookEntity.convert(item.getBook()),
                item.getDate());
    }
}
