package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, LocalDate> {
    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context){
        if(date == null){
            return false;
        } else {
            LocalDate currentDate = LocalDate.now();
            long yearsBetween = ChronoUnit.YEARS.between(date, currentDate);
            return yearsBetween > 10 && yearsBetween < 100;
        }
    }
}
