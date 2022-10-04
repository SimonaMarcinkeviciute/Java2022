package lt.codeacademy.libraryapi.controller;

import static lt.codeacademy.libraryapi.ApplicationPath.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @ApiOperation(value = "Update file in file system and metadata in db", tags = "updateFile", httpMethod = "PUT")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "File updated successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @PutMapping(UPDATE_FILE)
    public String updateFileMetadataInDb(@RequestParam MultipartFile multipartFile, @PathVariable(fileId) UUID id) {
        return  fileService.updateFileInFileSystemAndMetadataInDb(multipartFile, id).toString();

    }







}