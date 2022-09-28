package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.data.TransactionStatus;
import lt.codeacademy.libraryapi.dto.*;
import lt.codeacademy.libraryapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

@RestController
@RequestMapping(USERS)
@Api(tags = "Library user controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = USERS_REGISTRATION, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)//201
    //requestBody, kad galetume paduoti book, sumapintu paduotum duomenis su siuo objektu
    public void createUser(@RequestBody User user){
        userService.createUser(user);

    }

    @GetMapping(value = USER_NAME,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails isAvailable(@PathVariable(userName) String name) {


            return  userService.loadUserByUsername(name);
    }
}
