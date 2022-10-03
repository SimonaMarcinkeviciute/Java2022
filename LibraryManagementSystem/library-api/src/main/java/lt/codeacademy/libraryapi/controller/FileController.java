package lt.codeacademy.libraryapi.controller;

import static lt.codeacademy.libraryapi.ApplicationPath.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.service.FileService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping(FILES) //nutrodom kaip bus pasiekamas tas kontroleris
@Api(tags = "Library file controller")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @ApiOperation(value = "Save file in file system and metadata in db", tags = "postFile", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "File saved successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @PostMapping(METADATA)
    public String saveFileMetadataInDb(@RequestParam MultipartFile multipartFile) {
        return  fileService.saveFileInFileSystemAndMetadataInDb(multipartFile).toString();

    }

//    @GetMapping(FILE_METADATA)
//    //
//    public ResponseEntity<Resource> downloadFileMetadataFromDB(@PathVariable(ID) UUID id) throws FileNotFoundException {
//        File file = fileService.downloadFileFromFileSystemAndMetadataInDb(id);
//
//        //pasieme file is servise galim ir jo pasiimti inputstream
//        Resource resource = new InputStreamResource(file.getInputStream());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.valueOf(file.getMediaType()))
//                .headers(headers)
//                .body(resource);
//    }


//
//    @GetMapping(FILE_OBJECT)
////    public File getFileObjectById(@PathVariable(ID) UUID id) throws FileNotFoundException {
////        File file = fileService.getFileObjectById(id);
////        return fileService.getFileObjectById(id);
////    }






}