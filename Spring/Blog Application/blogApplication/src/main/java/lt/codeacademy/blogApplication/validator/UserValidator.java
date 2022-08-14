package lt.codeacademy.blogApplication.validator;

import lt.codeacademy.blogApplication.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "surname", "userValidator.surname.empty");
        ValidationUtils.rejectIfEmpty(errors, "username", "userValidator.username.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "userValidator.email.empty");
    }
}
