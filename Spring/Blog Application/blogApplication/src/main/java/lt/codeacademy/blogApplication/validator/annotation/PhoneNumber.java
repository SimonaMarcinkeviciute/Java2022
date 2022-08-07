package lt.codeacademy.blogApplication.validator.annotation;

import lt.codeacademy.blogApplication.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface PhoneNumber {
    String message() default "{phoneNumber.constraint.invalid}";

    Class<?>[]groups() default {};

    Class<? extends Payload>[] payload() default {};

    PhoneType type() default PhoneType.ALL;
}
