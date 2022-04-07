package org.jiang.combo.admin.common.validation;

import lombok.val;
import org.jiang.combo.admin.common.annotation.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static String EMAIL_PATTERN = "^5566@$";

    @Override
    public void initialize(ValidEmail constraintAnnotation) {}

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        val pattern = Pattern.compile(EMAIL_PATTERN);
        val matcher = pattern.matcher(s);

        return matcher.matches();
    }
}
