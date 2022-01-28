package org.jiang.combo.common.validation;

import org.jiang.combo.common.annotation.ValidRef;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
