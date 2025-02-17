package br.com.cdms.contact_manager.validation;

import br.com.cdms.contact_manager.models.enums.UF;
import br.com.cdms.contact_manager.validation.constraints.ValidUF;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class UFValidation implements ConstraintValidator<ValidUF, String> {
    @Override
    public void initialize(ValidUF constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<UF> ufs = List.of(UF.values());

        if (s != null) {
            try {
                return ufs.contains(UF.valueOf(s.toUpperCase()));
            }
            catch (IllegalArgumentException exception) {
                return false;
            }
        }
        return true;
    }
}
