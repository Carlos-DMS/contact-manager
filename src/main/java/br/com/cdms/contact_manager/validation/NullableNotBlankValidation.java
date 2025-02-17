package br.com.cdms.contact_manager.validation;

import br.com.cdms.contact_manager.validation.constraints.NullableNotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullableNotBlankValidation implements ConstraintValidator<NullableNotBlank, String> {

    @Override
    public void initialize(NullableNotBlank constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null) {
            return !s.isBlank();
        }
        return true;
    }
}
