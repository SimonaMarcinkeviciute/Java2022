package lt.codeacademy.blogApplication.contoller;

import lt.codeacademy.blogApplication.dto.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
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

    @GetMapping("/save")
    public String openUserRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "form/user";
    }

    @PostMapping("/save")
    public String createUser(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "form/user";
        }
        //TODO call service!!! latter!!!!

        return "redirect:/users/save";
    }

}
