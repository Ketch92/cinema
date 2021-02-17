package core.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidateEmail, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext cvx) {
        return str != null && !str.matches("[\\w+@[a-z]+.[a-z]+]");
    }
}
