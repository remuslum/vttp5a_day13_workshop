package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Define this annotation to be used on fields
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)

public @interface ValidDate {
    String message() default "Invalid Date, must be older than 10 years old and younger than 100 years old";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
