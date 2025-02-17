package br.com.cdms.contact_manager.validation;

import br.com.cdms.contact_manager.models.enums.TipoContato;
import br.com.cdms.contact_manager.validation.constraints.ValidTipoContato;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class TipoContatoValidation implements ConstraintValidator<ValidTipoContato, String> {
    @Override
    public void initialize(ValidTipoContato constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<TipoContato> tiposContatos = List.of(TipoContato.values());

        if (s != null) {
            try {
                return tiposContatos.contains(TipoContato.valueOf(s.toUpperCase()));
            }
            catch (IllegalArgumentException exception) {
                return false;
            }
        }
        return true;
    }
}
