package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.File;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.USERS;
import static lt.codeacademy.libraryapi.ApplicationPath.USERSREGISTRATION;

@RestController
@RequestMapping(USERS)
@Api(tags = "Library user controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = USERSREGISTRATION, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)//201
    //requestBody, kad galetume paduoti book, sumapintu paduotum duomenis su siuo objektu
    public void saveBooks(@RequestBody User user){
        userService.createUser(user);



    }
}
