package br.com.cdms.contact_manager.validation.constraints;

import br.com.cdms.contact_manager.validation.TipoContatoValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TipoContatoValidation.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTipoContato {
    String message() default "O campo tipoContato está inválido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
