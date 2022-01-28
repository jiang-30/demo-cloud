package org.jiang.combo.common.annotation;

import org.jiang.combo.common.validation.RefValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RefValidator.class)
public @interface ValidRef {
    String message() default "Not Matched";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] playload() default {};
}
