package br.com.cdms.contact_manager.validation.constraints;

import br.com.cdms.contact_manager.validation.NullableNotBlankValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NullableNotBlankValidation.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NullableNotBlank {
    String message() default "O campo não deve estar vazio.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
