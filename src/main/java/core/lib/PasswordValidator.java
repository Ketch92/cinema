package core.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<FieldMatch, Object> {
    private String field;
    private String fieldMatch;
    
    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }
    
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext cvc) {
        Object fieldValue = new BeanWrapperImpl(obj)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(obj)
                .getPropertyValue(fieldMatch);
    
        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
