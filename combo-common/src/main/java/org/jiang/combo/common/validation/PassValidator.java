package org.jiang.combo.common.validation;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jiang.combo.common.annotation.ValidPassword;
import org.passay.*;
import org.passay.spring.SpringMessageResolver;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@RequiredArgsConstructor
public class PassValidator implements ConstraintValidator<ValidPassword, String> {

    private final SpringMessageResolver springMessageResolver;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {}

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        val validator = new PasswordValidator(springMessageResolver, Arrays.asList(
                new LengthRule(6, 30),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 4, false)
        ));

        val result = validator.validate(new PasswordData(s));
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(String.join(",", validator.getMessages(result))).addConstraintViolation();
        return result.isValid();
    }
}
