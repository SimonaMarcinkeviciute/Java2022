package lt.codeacademy.blogApplication.validator;

import lt.codeacademy.blogApplication.dto.User;
import lt.codeacademy.blogApplication.validator.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        String password = user.getPassword();
        String repeatPassword = user.getRepeatPassword();

        return password != null && password.equals(repeatPassword);
    }
}
