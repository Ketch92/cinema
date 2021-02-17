package core.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidateEmail, String> {
    private static final String PASSWORD_REGEX = "[\\w+@[a-z]+.[a-z]+]";
    
    @Override
    public boolean isValid(String str, ConstraintValidatorContext cvx) {
        return str != null && !str.matches(PASSWORD_REGEX);
    }
}
