package br.com.cdms.contact_manager.validation.constraints;

import br.com.cdms.contact_manager.validation.UFValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UFValidation.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUF {
    String message() default "O campo UF está inválido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
