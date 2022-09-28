package lt.codeacademy.libraryapi.controller;


import lt.codeacademy.libraryapi.dto.Login;
import lt.codeacademy.libraryapi.dto.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lt.codeacademy.libraryapi.ApplicationPath.LOGIN;

@RestController
@RequestMapping(LOGIN)
public class LoginController {

    @PostMapping
    //is konteksto paima principal is filtro ir grazina atgal,
    public Login login(@AuthenticationPrincipal User user) {
        return new Login(user);
    }
}
