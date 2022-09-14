package lt.codeacademy.eshopapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lt.codeacademy.eshopapi.entity.FileEntity;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class File {
    private UUID id;
    private String name;
    private String mediaType;
    private long size;
    private LocalDateTime timestamp;
    private InputStream inputStream;
    private byte[] bytes;

    public static File convert(FileEntity entity, InputStream inputStream) {
        return new File(entity.getId(),
                entity.getName(),
                entity.getMediaType(),
                entity.getSize(),
                entity.getTimestamp(),
                inputStream,
                entity.getBytes());
    }
}
