package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.entity.FileEntity;
import lt.codeacademy.libraryapi.exception.FileException;
import lt.codeacademy.libraryapi.repository.FileRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.UUID;

@Service
public class FileService {

    private final Path location;
    private final long MAX_FILE_SIZE = 10000000; //10MB
    private final Set<String> ALLOWED_CONTENT_TYPES = Set.of(MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE);
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
        //isrerolvina path, kur ta dierektorija turi buti ir jei tos dierktorijos nera sukuria
        location = Paths.get("./library-api/files").toAbsolutePath().normalize();
        createDirectory();
    }

    public UUID saveFileInFileSystemAndMetadataInDb(MultipartFile multipartFile) {
        validateFile(multipartFile);

        FileEntity file = new FileEntity(multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getSize());
        //save grazina ta pati objekta, tik updatinta ir grazina id
        file = fileRepository.save(file);

        saveFileInFileSystem(file.getId().toString(), multipartFile);
        return file.getId();
    }

    public UUID updateFileInFileSystemAndMetadataInDb(MultipartFile multipartFile, UUID id) {
        validateFile(multipartFile);

        FileEntity file = new FileEntity( id ,multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getSize());
        //save grazina ta pati objekta, tik updatinta ir grazina id
        file = fileRepository.save(file);

        saveFileInFileSystem(file.getId().toString(), multipartFile);
        return file.getId();
    }

    private void saveFileInFileSystem(String fileName, MultipartFile multipartFile) {
        try {
            //resolvina path is paduoto stringo, ir tenais suraso baitus
            Path fileLocation = location.resolve(fileName);
            //nurodom ka ir kur norim nukopijuoti
            Files.copy(multipartFile.getInputStream(), fileLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException e) {
            throw new FileException("Cannot save file");
        }
    }

    public File getFileObjectById(UUID id) throws FileNotFoundException {
        FileEntity entity = fileRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException(String.format("File %s not exist ", id)));

        try{
            Path path = location.resolve(entity.getId().toString());
            byte[] bytes = Files.readAllBytes(path);
            File file = File.convert(entity);
            file.setBytes(bytes);

            return file;
        }catch(IOException e) {
            throw new FileNotFoundException(String.format("File %s not exist ", id));
        }
    }

    private void createDirectory() {
        try {
            if(!Files.exists(location)) {
                Files.createDirectory(location);
            }
        } catch(IOException e) {
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
