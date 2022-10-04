package lt.codeacademy.libraryapi.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.Login;
import lt.codeacademy.libraryapi.dto.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lt.codeacademy.libraryapi.ApplicationPath.LOGIN;

@RestController
@RequestMapping(LOGIN)
@Api(tags = "Library login controller")
public class LoginController {

    @ApiOperation(value = "Log in user", tags = "userLogIn", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User log in successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @PostMapping
    //is konteksto paima principal is filtro ir grazina atgal,
    public Login login(@AuthenticationPrincipal User user) {
        return new Login(user);
    }
}
