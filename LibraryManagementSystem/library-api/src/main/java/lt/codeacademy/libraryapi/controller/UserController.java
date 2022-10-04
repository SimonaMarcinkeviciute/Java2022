package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.*;
import lt.codeacademy.libraryapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

@RestController
@RequestMapping(USERS)
@Api(tags = "Library user controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "Create user", tags = "createUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 20, message = "User created successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @PostMapping(value = USERS_REGISTRATION, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)//201
    //requestBody, kad galetume paduoti book, sumapintu paduotum duomenis su siuo objektu
    public void createUser(@RequestBody User user){
        userService.createUser(user);

    }

    @ApiOperation(value = "Check user name", tags = "checkUsername", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User name is available"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = USER_NAME,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails isAvailable(@PathVariable(userName) String name) {

            return  userService.loadUserByUsername(name);
    }
}
