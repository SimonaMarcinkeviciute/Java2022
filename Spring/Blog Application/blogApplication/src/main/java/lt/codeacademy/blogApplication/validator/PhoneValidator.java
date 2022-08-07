package lt.codeacademy.blogApplication.validator;

import lt.codeacademy.blogApplication.validator.annotation.PhoneNumber;
import lt.codeacademy.blogApplication.validator.annotation.PhoneType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {

    private PhoneType type;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        type = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        if(number == null) {
            return false;
        }

        return switch(type) {
            case ALL -> isNumberValid(number);
            case FULL -> isFullPhoneNumberValid(number);
            case PART -> isPartNumberValid(number);
        };
    }

    private boolean isNumberValid(String number) {
        return number.startsWith("+370") ? isFullPhoneNumberValid(number) : isPartNumberValid(number);
    }

    private boolean isPartNumberValid(String number) {
        try {
            Long.parseLong(number);
        } catch(NumberFormatException e) {
            return false;
        }

        return number.startsWith("86") && number.length() == 9;
    }

    private boolean isFullPhoneNumberValid(String number) {
        try {
            String tempNumb = number.substring(1, number.length() - 1);
            Long.parseLong(tempNumb);
        }catch(NumberFormatException e) {
            return false;
        }

        return number.startsWith("+370") && number.length() == 12;
    }
}
