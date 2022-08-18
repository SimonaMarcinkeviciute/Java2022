package lt.codeacademy.blogApplication.contoller;

import lt.codeacademy.blogApplication.dto.User;
import lt.codeacademy.blogApplication.service.MessageService;
import lt.codeacademy.blogApplication.service.UserService;
import lt.codeacademy.blogApplication.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserValidator userValidator;
    private final UserService userService;
    private final MessageService messageService;

    public UserController(UserValidator userValidator, UserService userService, MessageService messageService) {
        this.userValidator = userValidator;
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/save")
    public String openUserRegistrationForm(Model model, String message) {
        model.addAttribute("user", new User());
        model.addAttribute("message", messageService.getMessage(message));

        return "form/user";
    }

    @PostMapping("/save")
    public String createUser(@Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            log.debug("Cannot create user, has errors: {}", bindingResult.hasErrors());
            return "form/user";
        }

        String message = "lt.codeacademy.blogApplication.create.message.success";

        userService.createUser(user);

        return "redirect:/users/save?message=" + message;
    }

}
