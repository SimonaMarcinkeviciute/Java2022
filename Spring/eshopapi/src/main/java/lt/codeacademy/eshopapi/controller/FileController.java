package lt.codeacademy.eshopapi.controller;

import static lt.codeacademy.eshopapi.ApplicationPath.*;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lt.codeacademy.eshopapi.dto.File;
import lt.codeacademy.eshopapi.exception.data.ExceptionResponse;
import lt.codeacademy.eshopapi.service.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping(FILES)
@OpenAPIDefinition(tags = @Tag(name = "File Controller", description = "Upload/download files"))
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @Operation(tags = "File Controller", summary = "Save file in file system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "file saved successfully"),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @PostMapping
    public void saveFile(@RequestParam MultipartFile multipartFile) {
        fileService.saveFileInFileSystem(multipartFile);
    }

    @Operation(tags = "File Controller", summary = "Save file in file system and metadata in db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "file saved successfully"),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @PostMapping(METADATA)
    public void saveFileMetadataInDb(@RequestParam MultipartFile multipartFile) {
        fileService.saveFileInFileSystemAndMetadataInDb(multipartFile);
    }

    @Operation(tags = "File Controller", summary = "Save file in database as blob")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "file saved successfully"),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @PostMapping(BLOBS)
    public void saveFileAsBlob(@RequestParam MultipartFile multipartFile) {
        fileService.saveFileAsBlob(multipartFile);
    }

    @Operation(tags = "File Controller", summary = "Download file from file system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Download file successfully", content = {@Content(schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @GetMapping(FILE)
    public ResponseEntity<Resource> downloadFile(@PathVariable(FILE_NAME) String fileName) throws FileNotFoundException {
        InputStream inputStream = fileService.downloadFileFromFileSystem(fileName);

        Resource resource = new InputStreamResource(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        MediaType mediaType = fileService.getContentTypeFromName(fileName);

        return ResponseEntity.ok()
                .contentType(mediaType)
                .headers(headers)
                .body(resource);

    }

    @Operation(tags = "File Controller", summary = "Download file from server and metadata from DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File downloaded successfully"),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @GetMapping(FILE_METADATA)
    public ResponseEntity<Resource> downloadFileMetadataFromDB(@PathVariable(ID) UUID id) throws FileNotFoundException {
        File file = fileService.downloadFileFromFileSystemAndMetadataInDb(id);

        Resource resource = new InputStreamResource(file.getInputStream());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.getMediaType()))
                .headers(headers)
                .body(resource);
    }

    @Operation(tags = "File Controller", summary = "Download file from DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File downloaded successfully"),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @GetMapping(GET_BLOB)
    public ResponseEntity<Resource> downloadFileFromDdAsBlob(@PathVariable(ID) UUID id) throws FileNotFoundException {
        File file = fileService.getFileById(id);

        Resource resource = new ByteArrayResource(file.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.getMediaType()))
                .headers(headers)
                .body(resource);
    }
}
