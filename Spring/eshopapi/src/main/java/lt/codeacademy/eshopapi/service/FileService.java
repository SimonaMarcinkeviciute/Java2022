package lt.codeacademy.eshopapi.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshopapi.dto.File;
import lt.codeacademy.eshopapi.entity.FileEntity;
import lt.codeacademy.eshopapi.exception.FileException;
import lt.codeacademy.eshopapi.repository.FileRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
public class FileService {

    private static final long MAX_FILE_SIZE = 10000000; //10MB
    private static final Set<String> ALLOWED_CONTENT_TYPES = Set.of(MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE);

    private final Path location;
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;

        location = Paths.get("./files").toAbsolutePath().normalize();
        createDirectory();
    }

    public void saveFileInFileSystem(MultipartFile multipartFile) {
        validateFile(multipartFile);

        saveFileInFileSystem(getUniqueFileName(multipartFile), multipartFile);
    }

    public void saveFileInFileSystemAndMetadataInDb(MultipartFile multipartFile) {
        validateFile(multipartFile);

        FileEntity file = new FileEntity(multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getSize());
        file = fileRepository.save(file);

        saveFileInFileSystem(file.getId().toString(), multipartFile);
    }

    public void saveFileAsBlob(MultipartFile multipartFile) {
        validateFile(multipartFile);

        try {
            FileEntity entity = new FileEntity(multipartFile.getOriginalFilename(),
                    multipartFile.getContentType(),
                    multipartFile.getSize(),
                    multipartFile.getBytes());

            fileRepository.save(entity);
        } catch(IOException e) {
            throw new FileException(String.format("Cannot create %s file", multipartFile.getOriginalFilename()));
        }
    }

    private void saveFileInFileSystem(String fileName, MultipartFile multipartFile) {
        try {
            Path fileLocation = location.resolve(fileName);
            Files.copy(multipartFile.getInputStream(), fileLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException e) {
            log.error(e.getMessage());
            throw new FileException("Cannot save file");
        }
    }

    public InputStream downloadFileFromFileSystem(String fileName) throws FileNotFoundException {

        try {
            Path filePath = Files.walk(location)
                    .filter(path -> path.toFile().getName().contains(fileName))
                    .findFirst()
                    .orElse(null);

            if(filePath == null) {
                throw new FileNotFoundException(String.format("FileEntity %s does not exist", fileName));
            }

            return Files.newInputStream(filePath);
        } catch(IOException e) {
            log.error(e.getMessage());
            throw new FileNotFoundException(String.format("FileEntity %s does not exist", fileName));
        }
    }

    public File downloadFileFromFileSystemAndMetadataInDb(UUID id) throws FileNotFoundException {
        FileEntity entity = fileRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException(String.format("File %s not exist ", id)));

        try {
            Path filePath = location.resolve(entity.getId().toString());
            InputStream inputStream = Files.newInputStream(filePath);

            return File.convert(entity, inputStream);
        }catch(IOException e) {
            log.error(e.getMessage());
            throw new FileNotFoundException(String.format("FileEntity %s does not exist", id));
        }
    }

    public File getFileById(UUID id) throws FileNotFoundException {
        return fileRepository.findById(id)
                .map(file -> File.convert(file, null))
                .orElseThrow(() -> new FileNotFoundException(String.format("File %s not exist ", id)));
    }

    public MediaType getContentTypeFromName(String fileName) {
        String contentType = URLConnection.guessContentTypeFromName(fileName);

        return MediaType.valueOf(contentType);
    }

    private String getUniqueFileName(MultipartFile multipartFile) {
        return String.format("%s_%s", LocalDateTime.now().getNano(), multipartFile.getOriginalFilename());
    }

    private void createDirectory() {
        try {
            if(!Files.exists(location)) {
                Files.createDirectory(location);
            }
        } catch(IOException e) {
            log.error(e.getMessage());
            throw new FileException("Cannot create directory");
        }
    }

    private void validateFile(MultipartFile multipartFile) {
        if(multipartFile.getSize() > MAX_FILE_SIZE) {
            throw new FileException(String.format("FileEntity is %s is to big, must be less then %s B", multipartFile.getSize(), MAX_FILE_SIZE));
        }

        if(!ALLOWED_CONTENT_TYPES.contains(multipartFile.getContentType())) {
            throw new FileException(String.format("FileEntity type %s not allowed", multipartFile.getContentType()));
        }
    }
}
