package org.jiang.combo.common.annotation;

import org.jiang.combo.common.validation.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {
    String message() default "{validation.custom.email}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};
}
