package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lt.codeacademy.libraryapi.entity.FileEntity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public File(UUID id, String name, String mediaType, long size, LocalDateTime timestamp, byte[] bytes) {
        this.id = id;
        this.name = name;
        this.mediaType = mediaType;
        this.size = size;
        this.timestamp = timestamp;
        this.bytes = bytes;
    }

    public static File convert(FileEntity entity)  {
        Path location = Paths.get("./library-api/files").toAbsolutePath().normalize();
        Path path = location.resolve(entity.getId().toString());
        byte[] bytes;

        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file = new File(entity.getId(),
                entity.getName(),
                entity.getMediaType(),
                entity.getSize(),
                entity.getTimestamp());

        file.setBytes(bytes);

        return file;
    }

    public File(UUID id, String name, String mediaType, long size, LocalDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.mediaType = mediaType;
        this.size = size;
        this.timestamp = timestamp;
    }
}
