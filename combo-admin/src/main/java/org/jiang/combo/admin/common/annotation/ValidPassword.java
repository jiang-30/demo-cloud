package org.jiang.combo.admin.common.annotation;


import org.jiang.combo.admin.common.validation.PassValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PassValidator.class)
public @interface ValidPassword {
    String message() default "Invalid Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] playload() default {};
}
