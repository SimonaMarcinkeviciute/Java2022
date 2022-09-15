package lt.codeacademy.libraryapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileEntity
{
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String mediaType;
    private long size;
    @CreationTimestamp
    private LocalDateTime timestamp;

    public FileEntity(String name, String mediaType, long size) {
        this.name = name;
        this.mediaType = mediaType;
        this.size = size;
    }
}
