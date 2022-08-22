package lt.codeacademy.blogApplication.contoller;

import lt.codeacademy.blogApplication.dto.User;
import lt.codeacademy.blogApplication.service.MessageService;
import lt.codeacademy.blogApplication.service.UserService;
import lt.codeacademy.blogApplication.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/public/users")
public class UserController {

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
        model.addAttribute("url", "https://www.houseplantjournal.com/wp-content/uploads/2020/06/logo.svg");
        model.addAttribute("fotter", "https://plnts.com/_next/image?url=https%3A%2F%2Fwebshop.plnts.com%2Fmedia%2Fwysiwyg%2Fbanners%2FHomepage_banner_PLNTS_SS22.jpg&w=1920&q=75");

        return "form/user";
    }

    @PostMapping("/save")
    public String createUser(@Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            return "form/user";
        }

        String message = "lt.codeacademy.blogApplication.create.user.message.success";
        userService.createUser(user);

        return "redirect:/users/save?message= + message";
    }

}