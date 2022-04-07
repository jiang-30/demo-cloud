package org.jiang.combo.admin.common.validation;


import org.jiang.combo.admin.common.annotation.ValidRef;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 在类上使用
 */
public class RefValidator implements ConstraintValidator<ValidRef, Class> {
    @Override
    public void initialize(ValidRef constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Class aClass, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
